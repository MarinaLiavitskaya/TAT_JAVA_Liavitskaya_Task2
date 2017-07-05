package com.epam.liavitskaya.main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.BookDAO;
import com.epam.liavitskaya.main.dao.worker.DBWorker;
import com.epam.liavitskaya.main.dao.worker.PropertyLoader;
import com.epam.liavitskaya.main.enums.BookStatus;

public class SQLBookDao implements BookDAO {

	static final String ADD_BOOK = "INSERT INTO BOOKS(id, title, author, description, status, user_id) VALUES(?, ?, ?, ?, ?, ?)";
	static final String SHOW_ALL_BOOKS = "SELECT * FROM BOOKS";
	static final String UPDATE_BOOK = "UPDATE BOOKS SET column1 = value1, column2 = value2, ... WHERE ID = ?";
	static final String UPDATE_BOOK_DESCRIPTION = "UPDATE BOOKS SET description = ? WHERE ID = ?";
	static final String CHANGE_BOOK_STATUS = "UPDATE BOOKS SET status = ? WHERE ID = ?";
	static final String DELETE_BOOK = "DELETE FROM BOOKS WHERE ID = ?";

	Connection connection = null;
	PreparedStatement prStmt = null;
	Statement stmt = null;

	public SQLBookDao() {
		Properties properties = PropertyLoader.getProperties("libDB.properties");
		DBWorker dbWorker = new DBWorker(properties);
		connection = dbWorker.getConnection();
	}

	@Override
	public void addBook(Book book) {
		try {
			prStmt = connection.prepareStatement(ADD_BOOK);
			prStmt.setInt(1, book.getBookId());
			prStmt.setString(2, book.getTitle());
			prStmt.setString(3, book.getAuthor());
			prStmt.setString(4, book.getDescription());
			prStmt.setString(5, book.getBookStatus());
			// prStmt.setString(4, book.getDescription());
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
				se.printStackTrace();
			}
		}

	}

	@Override
	public void editBook(Book book) {

		try {
			prStmt = connection.prepareStatement(UPDATE_BOOK);
			prStmt.setString(1, book.getDescription());
			prStmt.setInt(2, book.getBookId());
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

	@Override
	public List<Book> bookFondReview() {
		Book book = null;
		List<Book> bookList = new ArrayList<>();
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SHOW_ALL_BOOKS);
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setDescription(rs.getString(4));
				book.setBookStatus(rs.getString(5));
				bookList.add(book);

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
					stmt.close();
			} catch (SQLException se) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return bookList;
	}

	@Override
	public void changeBookStatus(BookStatus bookStatus, int id) {
		try {
			prStmt = connection.prepareStatement(CHANGE_BOOK_STATUS);
			prStmt.setString(1, bookStatus.name());
			prStmt.setInt(2, id);
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

	@Override
	public void deleteBook(int id) {
		try {
			prStmt = connection.prepareStatement(DELETE_BOOK);
			prStmt.setInt(1, id);
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

	@Override
	public void delete() {
	}

}
