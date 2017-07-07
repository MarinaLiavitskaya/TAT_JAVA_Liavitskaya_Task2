package com.epam.liavitskaya.main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.BookDAO;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.enums.BookStatus;
import com.epam.liavitskaya.main.mysql.ConnectionManager;

public class SQLBookDao implements BookDAO {

	static final String ADD_BOOK = "INSERT INTO BOOKS(title, author, description, status) VALUES(?, ?, ?, ?)";
	static final String SHOW_ALL_BOOKS = "SELECT * FROM BOOKS";
	static final String UPDATE_BOOK = "UPDATE BOOKS SET column1 = value1, column2 = value2, ... WHERE BOOK_ID = ?";
	static final String UPDATE_BOOK_DESCRIPTION = "UPDATE BOOKS SET description = ? WHERE BOOK_ID = ?";
	static final String CHANGE_BOOK_STATUS = "UPDATE BOOKS SET status = ? WHERE BOOK_ID = ?";
	static final String DELETE_BOOK = "DELETE FROM BOOKS WHERE BOOK_ID = ?";

	Connection connection = null;
	PreparedStatement prStmt = null;
	ResultSet rs = null;

	public SQLBookDao() {
		connection = ConnectionManager.getManager().getConnection();
	}

	@Override
	public void addBook(Book book) throws DAOException {
		try {
			prStmt = connection.prepareStatement(ADD_BOOK);
			prStmt.setString(1, book.getTitle());
			prStmt.setString(2, book.getAuthor());
			prStmt.setString(3, book.getDescription());
			prStmt.setString(4, book.getBookStatus());
			prStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			// ConnectionManager.getManager().closeDbResources(connection,
			// prStmt);
		}
	}

	@Override
	public void editBook(Book book) throws DAOException {
		try {
			prStmt = connection.prepareStatement(UPDATE_BOOK);
			prStmt.setString(1, book.getDescription());
			prStmt.setInt(2, book.getBookId());
			prStmt.executeUpdate();
			// connection.commit();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			// ConnectionManager.getManager().closeDbResources(connection,
			// prStmt);
		}
	}

	@Override
	public List<Book> bookFondReview() throws DAOException {
		Book book = null;
		List<Book> bookList = new ArrayList<>();
		try {
			prStmt = connection.prepareStatement(SHOW_ALL_BOOKS);
			rs = prStmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setDescription(rs.getString(4));
				book.setBookStatus(rs.getString(5));
				bookList.add(book);

				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String description = rs.getString("description");
				String status = rs.getString("status");
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
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			// ConnectionManager.getManager().closeDbResources(connection,
			// prStmt, rs);
		}
		return bookList;
	}

	@Override
	public void changeBookStatus(BookStatus bookStatus, int id) throws DAOException {
		try {
			prStmt = connection.prepareStatement(CHANGE_BOOK_STATUS);
			prStmt.setString(1, bookStatus.name());
			prStmt.setInt(2, id);
			prStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			// ConnectionManager.getManager().closeDbResources(connection,
			// prStmt);
		}
	}

	@Override
	public void deleteBook(int id) throws DAOException {
		try {
			prStmt = connection.prepareStatement(DELETE_BOOK);
			prStmt.setInt(1, id);
			prStmt.executeUpdate();
			// connection.commit();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			// ConnectionManager.getManager().closeDbResources(connection,
			// prStmt);
		}
	}
}
