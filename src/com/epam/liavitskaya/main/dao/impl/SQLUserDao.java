package com.epam.liavitskaya.main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.UserDAO;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.enums.UserStatus;
import com.epam.liavitskaya.main.mysql.ConnectionManager;
import com.epam.liavitskaya.main.utils.PasswordEncryptorUtil;

public class SQLUserDao implements UserDAO {

	static final String FETCH_USER_LOGIN = "SELECT * FROM USERS WHERE login = ?";
	static final String ADD_USER = "INSERT INTO USERS(name, passport, phone, email, role, login, password, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	static final String ADD_USER_QUICK = "INSERT INTO USERS(name, role, login, password, status) VALUES(?, ?, ?, ?, ?)";
	static final String SHOW_ALL_USERS = "SELECT * FROM USERS";
	static final String SHOW_USER = "SELECT * FROM USERS WHERE id = ?";
	static final String UPDATE_USER_PROFILE = "UPDATE USERS SET name = ?, passport = ?, phone = ?, email = ?, login = ? WHERE ID = ?";
	static final String CHANGE_USER_ROLE = "UPDATE USERS SET role = ? WHERE ID = ?";
	static final String CHANGE_USER_STATUS = "UPDATE USERS SET status = ? WHERE ID = ?";
	static final String DELETE_USER = "DELETE FROM USERS WHERE ID = ?";

	Connection connection = null;
	PreparedStatement prStmt = null;
	ResultSet rs = null;

	public SQLUserDao() {
		connection = ConnectionManager.getManager().getConnection();
	}

	@Override
	public void singIn(String login, String password) throws DAOException {
		User currentUser = new User();			// подумать куда его положить
		try {
			prStmt = connection.prepareStatement(SHOW_USER);
			prStmt.setString(1, login);
			rs = prStmt.executeQuery();
			while (rs.next()) {	
				int id = rs.getInt("id");
				currentUser.setUserId(id);
				String name = rs.getString("name");
				currentUser.setUserName(name);
				String passport = rs.getString("passport");
				currentUser.setPassword(passport);
				String phone = rs.getString("phone");
				currentUser.setPhone(phone);
				String email = rs.getString("email");
				currentUser.setEmail(email);
				String role = rs.getString("role");
				currentUser.setUserRole(role);				
				currentUser.setLogin(login);				
				currentUser.setPassword(password);
				String status = rs.getString("status");
				currentUser.setUserStatus(status);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt, rs);
		}
	}

	@Override
	public void singOut(String login) {
		//	что-то хранящее юзера обнулить
	}

	@Override
	public void registration(User user) throws DAOException {
		try {
			prStmt = connection.prepareStatement(ADD_USER);
			prStmt.setString(1, user.getUserName());
			prStmt.setString(2, PasswordEncryptorUtil.encryptPassword(user.getUserPassportNo()));   //  !!!! перенести в сервис !
			prStmt.setString(3, user.getPhone());
			prStmt.setString(4, user.getEmail());
			prStmt.setString(5, user.getUserRole());
			prStmt.setString(6, user.getLogin());
			prStmt.setString(7, user.getPassword());
			prStmt.setString(8, user.getUserStatus());
			prStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
	}
	
	public void registrationQuick(User user) throws DAOException {
		try {
			prStmt = connection.prepareStatement(ADD_USER_QUICK);
			prStmt.setString(1, user.getUserName());						
			prStmt.setString(3, user.getUserRole());
			prStmt.setString(4, user.getLogin());
			prStmt.setString(5, user.getPassword());
			prStmt.setString(6, user.getUserStatus());
			prStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
	}	

	@Override
	public User getProfile(int id) throws DAOException {
		User user = new User();		
		try {
			prStmt = connection.prepareStatement(SHOW_USER);
			prStmt.setInt(1, id);
			rs = prStmt.executeQuery();
			while (rs.next()) {	
				user.setUserId(id);
				String name = rs.getString("name");
				user.setUserName(name);
				String passport = rs.getString("passport");
				user.setPassword(passport);
				String phone = rs.getString("phone");
				user.setPhone(phone);
				String email = rs.getString("email");
				user.setEmail(email);
				String role = rs.getString("role");
				user.setUserRole(role);
				String login = rs.getString("login");
				user.setLogin(login);
				String password = rs.getString("password");
				user.setPassword(password);
				String status = rs.getString("status");
				user.setUserStatus(status);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt, rs);
		}
		return user;
	}
	
	@Override
	public void updateProfile(User user) throws DAOException {
		try {
			prStmt = connection.prepareStatement(UPDATE_USER_PROFILE);
			prStmt.setString(1, user.getUserName());
			prStmt.setString(2, user.getUserPassportNo());
			prStmt.setString(3, user.getPhone());
			prStmt.setString(4, user.getEmail());			
			prStmt.setString(5, user.getLogin());			
			prStmt.setInt(6, user.getUserId());
			prStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
	}

	@Override
	public List<User> showAllUsers() throws DAOException {
		User user = new User();
		List<User> userList = new ArrayList<>();		
		try {
			prStmt = connection.prepareStatement(SHOW_ALL_USERS);
			rs = prStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				user.setUserId(id);
				String name = rs.getString("name");
				user.setUserName(name);
				String passport = rs.getString("passport");
				user.setPassword(passport);
				String phone = rs.getString("phone");
				user.setPhone(phone);
				String email = rs.getString("email");
				user.setEmail(email);
				String role = rs.getString("role");
				user.setUserRole(role);
				String login = rs.getString("login");
				user.setLogin(login);
				String password = rs.getString("password");
				user.setPassword(password);
				String status = rs.getString("status");
				user.setUserStatus(status);
				// Display values
//				System.out.println("ID: " + id);
//				System.out.println(", name: " + name);
//				System.out.println(", role: " + role);
//				System.out.println(", login: " + login);
//				System.out.println(", Status: " + status);
//				System.out.println(", password: " + password);
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt, rs);
		}
		return userList;
	}

	@Override
	public void changeUserStatus(UserStatus userStatus, int id) throws DAOException {
		try {
			prStmt = connection.prepareStatement(CHANGE_USER_STATUS);
			prStmt.setString(1, userStatus.name());
			prStmt.setInt(2, id);
			prStmt.executeUpdate();
			// connection.commit();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
	}

	@Override
	public void changeUserRole(UserRoles userRoles, int id) throws DAOException {
		try {
			prStmt = connection.prepareStatement(CHANGE_USER_ROLE);
			prStmt.setString(1, userRoles.name());
			prStmt.setInt(2, id);			
			prStmt.executeUpdate();
			// connection.commit();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
	}

	@Override
	public void deleteUser(int userId) throws DAOException {
		try {
			prStmt = connection.prepareStatement(DELETE_USER);
			prStmt.setInt(1, userId);
			prStmt.executeUpdate();
			// connection.commit();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
	}

	@Override
	public List<String> showAllLogins() throws DAOException {
		List<String> loginList = new ArrayList<>();		
		try {
			prStmt = connection.prepareStatement(SHOW_ALL_USERS);
			rs = prStmt.executeQuery();
			while (rs.next()) {
				String login = rs.getString("login");
				loginList.add(login);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
		return loginList;
	}

	@Override
	public List<String> showAllPasswords() throws DAOException {
		List<String> passwordList = new ArrayList<>();		
		try {
			prStmt = connection.prepareStatement(SHOW_ALL_USERS);
			rs = prStmt.executeQuery();
			while (rs.next()) {
				String password = rs.getString("password");
				passwordList.add(password);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, prStmt);
		}
		return passwordList;
	}

}
