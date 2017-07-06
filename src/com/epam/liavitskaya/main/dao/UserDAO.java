package com.epam.liavitskaya.main.dao;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.enums.UserStatus;

public interface UserDAO {
	
	void singIn(String login, String password) throws DAOException;
	void singOut(String login) throws DAOException;
	void registration(User user) throws DAOException;
	User getProfile(int id) throws DAOException;
	void updateProfile(User user) throws DAOException;
	List<User> showAllUsers() throws DAOException;
	List<String> showAllLogins() throws DAOException;
	List<String> showAllPasswords() throws DAOException;
	void changeUserStatus(UserStatus userStatus, int id) throws DAOException;
	void changeUserRole(UserRoles userRoles, int id) throws DAOException;
	void deleteUser(int userId) throws DAOException;
}
