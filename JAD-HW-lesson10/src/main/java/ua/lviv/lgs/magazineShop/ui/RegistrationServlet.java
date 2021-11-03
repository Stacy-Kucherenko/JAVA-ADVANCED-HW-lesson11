package ua.lviv.lgs.magazineShop.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.lviv.lgs.magazineShop.dao.DAOException;
import ua.lviv.lgs.magazineShop.domain.AccessLevel;
import ua.lviv.lgs.magazineShop.domain.User;
import ua.lviv.lgs.magazineShop.service.UserService;
import ua.lviv.lgs.magazineShop.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserServiceImpl.getUserService();

	private Logger log = Logger.getLogger(RegistrationServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("Opening Registration Form...");
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("Getting fields values from Registration Form...");
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String accessLevel = null;

		if ("user".equals(request.getParameter("accessLevel"))) {
			accessLevel = AccessLevel.USER.toString();
		} else if ("admin".equals(request.getParameter("accessLevel"))) {
			accessLevel = AccessLevel.ADMIN.toString();
		}

		try {
			log.trace("Saving user in database...");
			userService.insert(new User(firstName, lastName, email, password, accessLevel));
		} catch (DAOException e) {
			log.error("Creating user failed!", e);
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");		
	}

}