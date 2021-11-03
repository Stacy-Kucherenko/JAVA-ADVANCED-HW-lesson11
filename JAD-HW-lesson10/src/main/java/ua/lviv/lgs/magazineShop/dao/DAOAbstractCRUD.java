package ua.lviv.lgs.magazineShop.dao;

import java.util.List;

public interface DAOAbstractCRUD<T> {

	T insert(T t) throws DAOException;

	List<T> readAll() throws DAOException;
	
	T readByID(int id) throws DAOException;

	boolean updateByID(T t) throws DAOException;

	boolean delete(int id) throws DAOException;

}