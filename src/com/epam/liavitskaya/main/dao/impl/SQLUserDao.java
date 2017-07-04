package com.epam.liavitskaya.main.dao.impl;

import java.sql.Connection;
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
	Statement stmt = null;
	Connection connection = null;

	public SQLUserDao() {
		Properties properties = PropertyLoader.getProperties("libDB.properties");
		DBWorker dbWorker = new DBWorker(properties);
		connection = dbWorker.getConnection();
	}

	@Override
	public void singIn(String login, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registration(User user) {
		try {
			stmt = connection.createStatement();
			String sqlI = "INSERT INTO USERS(id, name, role, login, password, status, library_card) VALUES(7, 'Pol', 'USER', 'xxx', 111, 1, 666)";
			stmt.executeUpdate(sqlI);

			String sqlS = "SELECT id, name, role, login, password, status, library_card FROM USERS";
			ResultSet rs = stmt.executeQuery(sqlS);
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
					connection.close();
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
			String sqlS = "SELECT id, name, role, login, password, status, library_card FROM USERS";
			ResultSet rs = stmt.executeQuery(sqlS);
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
					connection.close();
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
	public void changeUserStatus() {

	}

	@Override
	public void changeUserRole() {

	}

	@Override
	public void deleteUser() {

	}

}
