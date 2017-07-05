package com.epam.liavitskaya.main.dao;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.exception.DAOException;

public interface UserDAO {
	
	void singIn(String login, String password) throws DAOException;
	void singOut(String login) throws DAOException;
	void registration(User user) throws DAOException;
	List<User> showAllUsers();
	void changeUserStatus(User id);  // active   inactive
	void changeUserRole(User id);
	void deleteUser(int userId);
}
