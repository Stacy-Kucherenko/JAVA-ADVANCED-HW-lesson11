package ua.lviv.lgs.magazineShop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ua.lviv.lgs.magazineShop.dao.DAOException;
import ua.lviv.lgs.magazineShop.domain.Magazine;
import ua.lviv.lgs.magazineShop.domain.Subscribe;
import ua.lviv.lgs.magazineShop.domain.User;
import ua.lviv.lgs.magazineShop.service.MagazineService;
import ua.lviv.lgs.magazineShop.service.SubscribeService;
import ua.lviv.lgs.magazineShop.service.UserService;
import ua.lviv.lgs.magazineShop.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.magazineShop.service.impl.SubscribeServiceImpl;
import ua.lviv.lgs.magazineShop.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) throws DAOException {
		Logger log = Logger.getLogger(Main.class);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		log.trace("Starting application...");
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("Иван", "Петренко", "petrenko@gmail.com", "123456", "USER"));
		userList.add(new User("Василий", "Иванов", "vas_ivanov@gmail.com", "123456", "USER"));

		UserService userService = UserServiceImpl.getUserService();
		userList.forEach(user -> {
			try {
				System.out.println(userService.insert(user));
			} catch (DAOException e) {
				log.error("Error occured!", e);
				e.printStackTrace();
			}
		});
		
		System.out.println(userService.readByID(2));
		System.out.println(userService.readByEmail("petrenko@gmail.com"));
		userService.updateByID(new User(1, "Джон", "Питерс", "petrenko@gmail.com", "123456", "АDMIN"));
		userService.updateByEmail(new User("Вася", "Иванов", "vas_ivanov@gmail.com", "123456", "USER"));
		userService.delete(1);
		userService.readAll().forEach(System.out::println);

		MagazineService magazineService = MagazineServiceImpl.getMagazineService();
		System.out.println(
				magazineService.insert(new Magazine("Playboy", "Алина Альвинская покоряет шоу-бизнес и продает экзотические острова!",
						LocalDate.parse("2019-04-01"), 6005)));
		magazineService.readAll().forEach(System.out::println);

		SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
		System.out.println(subscribeService.insert(new Subscribe(2, 1, true, LocalDate.parse("2019-04-26"), 12)));
		subscribeService.readAll().forEach(System.out::println);
	}
}
