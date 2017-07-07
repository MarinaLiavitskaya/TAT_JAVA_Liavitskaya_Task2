package com.epam.liavitskaya.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.UserDAO;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.dao.factory.DAOFactory;
import com.epam.liavitskaya.main.dao.impl.SQLUserDao;
import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.enums.UserStatus;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;
import com.epam.liavitskaya.main.utils.PasswordEncryptorUtil;
import com.epam.liavitskaya.main.utils.RequestParserUtil;
import com.epam.liavitskaya.main.utils.ValidatorUtil;

public class ClientServiceImpl implements ClientService {

	final static Logger logger = Logger.getLogger(ClientServiceImpl.class);

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

		String[] parseRequest = RequestParserUtil.parseRequest(request, 9);
		String login = parseRequest[6];
		String password = parseRequest[7];

		if (login == null || login.isEmpty() || !ValidatorUtil.isLoginValid(login)) {
			throw new ServiceException();
		}

		if (password == null || password.isEmpty() || !ValidatorUtil.isPasswordValid(password)) {
			throw new ServiceException();
		}

		String encryptPassword = PasswordEncryptorUtil.encryptPassword(parseRequest[7]);

		if (isPasswordExist(encryptPassword) || isLoginExist(login)) {
			throw new ServiceException("incorrect registration input");
		}
		User user = new User(parseRequest[1], parseRequest[2], parseRequest[3], parseRequest[4],
				UserRoles.valueOf(parseRequest[5]), parseRequest[6], encryptPassword,
				UserStatus.valueOf(parseRequest[8]));
		try {
			userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public User reviewProfile(String request) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		String[] parseRequest = RequestParserUtil.parseRequest(request, 2);
		int id = Integer.parseInt(parseRequest[1]);
		User profile = new User();
		try {
			profile = userDAO.getProfile(id);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return profile;
	}

	@Override
	public void editProfile(String request) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		String[] parseRequest = RequestParserUtil.parseRequest(request, 8);
		int id = Integer.parseInt(parseRequest[1]);
		User user = new User(parseRequest[2], parseRequest[3], parseRequest[4], parseRequest[5], parseRequest[6], parseRequest[7]);
		try {
			userDAO.updateProfile(user, id);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}
	
	@Override
	public void editStatus(String request) throws ServiceException {
		UserDAO userDAO = new SQLUserDao();
		String[] parseRequest = RequestParserUtil.parseRequest(request, 2);
		String status = parseRequest[0];
		UserStatus userStatus = UserStatus.valueOf(status);
		int id = Integer.parseInt(parseRequest[1]);		
		try {
			userDAO.changeUserStatus(userStatus, id);
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
		List<String> fetchAllLogins = new ArrayList<>();
		UserDAO userDAO = new SQLUserDao();
		try {
			fetchAllLogins = userDAO.showAllLogins();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return fetchAllLogins;
	}

	public List<String> fetchAllPasswords() throws ServiceException {
		List<String> fetchAllPasswords = new ArrayList<>();
		UserDAO userDAO = new SQLUserDao();
		try {
			fetchAllPasswords = userDAO.showAllPasswords();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return fetchAllPasswords;
	}

	private static boolean isPasswordExist(String password) {

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		List<String> fetchAllPasswords = new ArrayList<>();
		try {
			fetchAllPasswords = clientService.fetchAllPasswords();
		} catch (ServiceException e) {
			logger.debug("Error during is Password Original check", e);
			e.printStackTrace();
		}
		return fetchAllPasswords.contains(password);
	}

	private static boolean isLoginExist(String login) {

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		List<String> fetchAllLogins = new ArrayList<>();
		try {
			fetchAllLogins = clientService.fetchAllLogins();
		} catch (ServiceException e) {
			logger.debug("Error during is Login Original check", e);
			e.printStackTrace();
		}		
		return fetchAllLogins.contains(login);
	}
	
}
