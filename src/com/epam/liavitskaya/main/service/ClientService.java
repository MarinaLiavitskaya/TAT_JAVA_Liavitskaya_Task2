package com.epam.liavitskaya.main.service;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;

public interface ClientService {

	void singIn(String login, String password);

	void singOut(String login);

	void registration(User user);
	
	List<User> shouAllUsers();

}
