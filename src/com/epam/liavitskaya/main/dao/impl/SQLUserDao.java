package com.epam.liavitskaya.main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.dao.UserDAO;
import com.epam.liavitskaya.main.dao.worker.DBWorker;
import com.epam.liavitskaya.main.dao.worker.PropertyLoader;

public class SQLUserDao implements UserDAO {

	static final String ADD_USER = "INSERT INTO USERS(name, role, login, password, status) VALUES(?, ?, ?, ?, ?)";
	static final String SHOW_ALL_USERS = "SELECT * FROM USERS";
	static final String UPDATE_USER = "UPDATE USERS SET column1 = value1, column2 = value2, ... WHERE ID = ?";
	static final String DELETE_USER = "DELETE FROM USERS WHERE ID = ?";

	Connection connection = null;
	PreparedStatement prStmt = null;
	Statement stmt = null;

	public SQLUserDao() {
		Properties properties = PropertyLoader.getProperties("libDB.properties");
		DBWorker dbWorker = new DBWorker(properties);
		connection = dbWorker.getConnection();
	}

	@Override
	public void singIn(String login, String password) {

	}

	@Override
	public void singOut(String login) {

	}

	@Override
	public void registration(User user) {
		try {
			prStmt = connection.prepareStatement(ADD_USER);			
			prStmt.setString(1, user.getUserName());
			prStmt.setString(2, user.getUserRole());
			prStmt.setString(3, user.getLogin());
			prStmt.setString(4, user.getPassword());
			prStmt.setString(5, user.getUserStatus());			
			prStmt.executeUpdate();
		} catch (SQLException se) {
		} catch (Exception e) {
		} finally {
			try {
				if (prStmt != null)
					prStmt.close();
			} catch (SQLException se) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
			}
		}
	}

	@Override
	public List<User> showAllUsers() {
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SHOW_ALL_USERS);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String role = rs.getString("role");
				String login = rs.getString("login");
				String password = rs.getString("password");
				int status = rs.getInt("status");
				String library_card = rs.getString("library_card");
				// Display values
				System.out.println("ID: " + id);
				System.out.println(", name: " + name);
				System.out.println(", role: " + role);
				System.out.println(", login: " + login);
				System.out.println(", Status: " + status);
				System.out.println(", password: " + password);
				System.out.println(", library_card: " + library_card);
			}
			rs.close();
		} catch (SQLException se) {
		} catch (Exception e) {
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
			}
		}
		return null;
	}

	@Override
	public void changeUserStatus(User id) {

	}

	@Override
	public void changeUserRole(User id) {

	}

	@Override
	public void deleteUser(int userId) {
		try {
			prStmt = connection.prepareStatement(DELETE_USER);
			prStmt.setInt(1, userId);
			prStmt.executeUpdate();
			// connection.commit();
		} catch (SQLException se) {
			if (connection != null) {
				try {
					// System.err.print("Transaction is being rolled back");
					// connection.rollback();
					connection.close();
				} catch (SQLException excep) {
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				if (prStmt != null)
					prStmt.close();
			} catch (SQLException se) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
			}
		}
	}

}
