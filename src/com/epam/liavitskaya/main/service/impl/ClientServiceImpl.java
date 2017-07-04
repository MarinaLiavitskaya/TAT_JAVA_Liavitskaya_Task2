package com.epam.liavitskaya.main.service.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.UserDAO;
import com.epam.liavitskaya.main.dao.impl.SQLUserDao;
import com.epam.liavitskaya.main.service.ClientService;

public class ClientServiceImpl implements ClientService {

	@Override
	public void singIn(String login, String pasword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void singOut(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registration(User user) {
		UserDAO userDAO = new SQLUserDao();
		userDAO.registration(user);		
	}

	@Override
	public List<User> shouAllUsers() {
		UserDAO userDAO = new SQLUserDao();
		List<User> allUsers = userDAO.showAllUsers();
		return allUsers;
	}
}
