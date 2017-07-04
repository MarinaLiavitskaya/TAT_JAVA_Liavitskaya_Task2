package com.epam.liavitskaya.main.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.BookDAO;
import com.epam.liavitskaya.main.dao.worker.DBWorker;
import com.epam.liavitskaya.main.dao.worker.PropertyLoader;

public class SQLBookDao implements BookDAO {
	Statement stmt = null;
	Connection connection = null;

	public SQLBookDao() {
		Properties properties = PropertyLoader.getProperties("libDB.properties");
		DBWorker dbWorker = new DBWorker(properties);
		connection = dbWorker.getConnection();
	}

	@Override
	public void addBook() {
		try {
			stmt = connection.createStatement();
			String sqlI = "INSERT INTO BOOKS(id, title, author, description, status, user_id) VALUES(1, 'HarryPotter 1', 'J.K.Rowling', 'MagicIsAllAroundUs', 0, 1)";
			stmt.executeUpdate(sqlI);

			String sqlS = "SELECT id, title, author, description, status, user_id FROM BOOKS";
			ResultSet rs = stmt.executeQuery(sqlS);
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String description = rs.getString("description");
				int status = rs.getInt("status");
				int user_id = rs.getInt("user_id");
				// // Display values
				// System.out.println("ID: " + id);
				// System.out.println(", title: " + title);
				// System.out.println(", author: " + author);
				// System.out.println(", Status: " + status);
				// System.out.println(", description: " + description);
				// System.out.println(", user_id: " + user_id);
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
				se.printStackTrace();
			}
		}

	}

	@Override
	public void editBookDescription() {

	}

	@Override
	public List<Book> bookFondReview() {
		try {
			stmt = connection.createStatement();			

			//String sqlS = "SELECT id, name, role, login, password, status, library_card FROM USERS";
			String sqlS = "SELECT * FROM BOOKS";
			ResultSet rs = stmt.executeQuery(sqlS);
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String description = rs.getString("description");
				int status = rs.getInt("status");
				int user_id = rs.getInt("user_id");
				// Display values
				System.out.println("ID: " + id);
				System.out.println(", title: " + title);
				System.out.println(", author: " + author);
				System.out.println(", Status: " + status);
				System.out.println(", description: " + description);
				System.out.println(", user_id: " + user_id);
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
				se.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void changeBookStatus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
}
