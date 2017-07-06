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
import com.epam.liavitskaya.main.utils.ValidatorUtil;

public class ClientServiceImpl implements ClientService {

	@Override
	public void singIn(String login, String password) throws ServiceException {

		if (login == null || login.isEmpty() || !ValidatorUtil.isLoginValid(login)) {
			throw new ServiceException("incorrect input");
		}

		if (password == null || password.isEmpty() || !ValidatorUtil.isPasswordValid(password)) {
			throw new ServiceException("incorrect input");
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

		if (login == null || login.isEmpty() || !ValidatorUtil.isLoginValid(login)) {
			throw new ServiceException("incorrect input");
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
		String login = parseRequest[3];
		String password = parseRequest[4];

		if (login == null || login.isEmpty() || !ValidatorUtil.isLoginValid(login)) {
			throw new ServiceException();
		}

		if (password == null || password.isEmpty() || !ValidatorUtil.isPasswordValid(password)) {
			throw new ServiceException();
		}
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
	public User reviewProfile(int id) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		User profile = new User();
		try {
			profile = userDAO.getProfile(id);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return profile;
	}

	@Override
	public void editProfile(User user) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		try {
			userDAO.updateProfile(user);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<User> showAllUsers() throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		List<User> allUsers;
		try {
			allUsers = userDAO.showAllUsers();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return allUsers;
	}

	@Override
	public void deleteUser(int userId) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		try {
			userDAO.deleteUser(userId);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public List<String> fetchAllLogins() throws ServiceException {
		List<String> fetchAllLogins = null;
		UserDAO userDAO = new SQLUserDao();
		try {
			userDAO.showAllLogins();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return fetchAllLogins;
	}

	public List<String> fetchAllPasswords() throws ServiceException {
		List<String> fetchAllPasswords = null;
		UserDAO userDAO = new SQLUserDao();
		try {
			userDAO.showAllPasswords();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return fetchAllPasswords;
	}
}
