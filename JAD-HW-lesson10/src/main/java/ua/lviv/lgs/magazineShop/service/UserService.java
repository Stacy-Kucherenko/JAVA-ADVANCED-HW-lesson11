package ua.lviv.lgs.magazineShop.service;

import ua.lviv.lgs.magazineShop.dao.DAOAbstractCRUD;
import ua.lviv.lgs.magazineShop.dao.DAOException;
import ua.lviv.lgs.magazineShop.domain.User;

public interface UserService extends DAOAbstractCRUD<User>{
	
	User readByEmail(String email) throws DAOException;

	boolean updateByEmail(User t) throws DAOException;

}
