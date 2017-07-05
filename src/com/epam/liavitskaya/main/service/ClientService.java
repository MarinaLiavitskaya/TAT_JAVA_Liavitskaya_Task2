package com.epam.liavitskaya.main.service;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.service.exception.ServiceException;

public interface ClientService {

	void singIn(String login, String password) throws ServiceException;

	void singOut(String login) throws ServiceException;

	void registration(String request) throws ServiceException;
	
	List<User> showAllUsers() throws ServiceException;
	
	void deleteUser(int userId) throws ServiceException;

}
