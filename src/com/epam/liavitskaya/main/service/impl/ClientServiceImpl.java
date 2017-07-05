package com.epam.liavitskaya.main.service.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.UserDAO;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.dao.factory.DAOFactory;
import com.epam.liavitskaya.main.dao.impl.SQLUserDao;
import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.enums.UserStatus;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.utils.RequestParserUtil;

public class ClientServiceImpl implements ClientService {

	@Override
	public void singIn(String login, String password) throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException();
		}

		if (password == null || password.isEmpty()) {
			throw new ServiceException();
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			userDAO.singIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void singOut(String login) throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException();
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			userDAO.singOut(login);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		
	}

	@Override
	public void registration(String request) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		String[] parseRequest = RequestParserUtil.parseRequest(request);
		// if(Validatir.validate()){}
		User user = new User(parseRequest[1], UserRoles.valueOf(parseRequest[2]), parseRequest[3], parseRequest[4],
				UserStatus.valueOf(parseRequest[5]));
		try {
			userDAO.registration(user);
		} catch (DAOException e) {			
			throw new ServiceException();
		}
	}

	@Override
	public List<User> showAllUsers() {
		UserDAO userDAO = new SQLUserDao();
		List<User> allUsers = userDAO.showAllUsers();
		return allUsers;
	}

	@Override
	public void deleteUser(int userId) {
		UserDAO userDAO = new SQLUserDao();
		userDAO.deleteUser(userId);

	}

}
