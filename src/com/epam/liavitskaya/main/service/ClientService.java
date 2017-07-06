package com.epam.liavitskaya.main.service;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.service.exception.ServiceException;

public interface ClientService {

	void singIn(String login, String password) throws ServiceException;

	void singOut(String login) throws ServiceException;

	void registration(String request) throws ServiceException;

	User reviewProfile(int id) throws ServiceException;

	void editProfile(User user) throws ServiceException;

	List<User> showAllUsers() throws ServiceException;

	List<String> fetchAllLogins() throws ServiceException;

	List<String> fetchAllPasswords() throws ServiceException;

	void deleteUser(int userId) throws ServiceException;

}
