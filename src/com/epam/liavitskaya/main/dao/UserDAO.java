package com.epam.liavitskaya.main.dao;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;

public interface UserDAO {
	
	void singIn(String login, String password);
	void registration(User user);
	List<User> showAllUsers();
	void changeUserStatus();   // active   inactive
	void changeUserRole();
	void deleteUser();
}
