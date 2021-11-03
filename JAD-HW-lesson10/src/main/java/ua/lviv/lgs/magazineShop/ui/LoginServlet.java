package ua.lviv.lgs.magazineShop.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.lviv.lgs.magazineShop.dao.DAOException;
import ua.lviv.lgs.magazineShop.domain.User;
import ua.lviv.lgs.magazineShop.dto.UserLogin;
import ua.lviv.lgs.magazineShop.service.UserService;
import ua.lviv.lgs.magazineShop.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserServiceImpl.getUserService();

	private Logger log = Logger.getLogger(LoginServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("Opening Login Form...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("Getting fields values from Login Form...");
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User user = null;

		try {
			log.trace("Getting user from database...");
			user = userService.readByEmail(login);
		} catch (DAOException e) {
			log.error("Getting user by email failed!", e);
		}

		if (user == null) {
			log.warn("There is no user with login \"" + login + "\" in database!");
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Пользователя с логином \"" + login + "\" в базе данных не существует!");
		} else {
			log.trace("Checking user's password for matching database...");
			if (user.getPassword().equals(password)) {
				log.trace("Keeping user's ID in opened session...");
				HttpSession session = request.getSession(true);
				session.setAttribute("userID", user.getId());
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("lastName", user.getLastName());
				session.setAttribute("accessLevel", user.getAccessLevel());
				
				log.trace("Redirecting to User's account page...");
				UserLogin userLogin = new UserLogin(user.getEmail(), "cabinet.jsp");
				String json = new Gson().toJson(userLogin);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
			} else {
				log.warn("User's password doesn't match database!");
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("Введенный пароль не совпадает с базой данных!");
			}
		}

	}

}