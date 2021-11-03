package ua.lviv.lgs.magazineShop.service.impl;

import java.util.List;

import ua.lviv.lgs.magazineShop.dao.DAOException;
import ua.lviv.lgs.magazineShop.dao.SubscribeDAO;
import ua.lviv.lgs.magazineShop.dao.impl.SubscribeDAOImpl;
import ua.lviv.lgs.magazineShop.domain.Subscribe;
import ua.lviv.lgs.magazineShop.service.SubscribeService;

public class SubscribeServiceImpl implements SubscribeService {
	private static SubscribeService subscribeService;
	private SubscribeDAO subscribeDAO;

	private SubscribeServiceImpl() {
		this.subscribeDAO = new SubscribeDAOImpl();
	}

	public static SubscribeService getSubscribeService() {
		if (subscribeService == null) {
			subscribeService = new SubscribeServiceImpl();
		}

		return subscribeService;
	}
	
	@Override
	public Subscribe insert(Subscribe t) throws DAOException {
		return subscribeDAO.insert(t);
	}

	@Override
	public List<Subscribe> readAll() throws DAOException {
		return subscribeDAO.readAll();
	}

	@Override
	public Subscribe readByID(int id) throws DAOException {
		return subscribeDAO.readByID(id);
	}

	@Override
	public boolean updateByID(Subscribe t) throws DAOException {
		return subscribeDAO.updateByID(t);
	}

	@Override
	public boolean delete(int id) throws DAOException {
		return subscribeDAO.delete(id);
	}

}
