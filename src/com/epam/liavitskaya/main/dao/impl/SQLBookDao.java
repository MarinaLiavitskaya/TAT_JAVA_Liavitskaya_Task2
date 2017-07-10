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
	// static final String UPDATE_BOOK = "UPDATE BOOKS SET column1 = value1,
	// column2 = value2, ... WHERE BOOK_ID = ?";
	static final String UPDATE_BOOK_DESCRIPTION = "UPDATE BOOKS SET description = ? WHERE BOOK_ID = ?";
	static final String CHANGE_BOOK_STATUS = "UPDATE BOOKS SET status = ? WHERE BOOK_ID = ?";
	static final String ROW_COUNT = "SELECT COUNT(*) FROM BOOKS";
	static final String DELETE_BOOK = "DELETE FROM BOOKS WHERE BOOK_ID = ?";

	Connection connection = null;

	public SQLBookDao() {
		connection = ConnectionManager.getManager().getConnection();
	}

	@Override
	public void addBook(Book book) throws DAOException {

		PreparedStatement prStmt = null;

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
			ConnectionManager.getManager().closeDbResources(prStmt);
		}
	}

	@Override
	public void editBook(Book book) throws DAOException {

		PreparedStatement prStmt = null;

		try {
			prStmt = connection.prepareStatement(UPDATE_BOOK_DESCRIPTION);
			prStmt.setString(1, book.getDescription());
			prStmt.setInt(2, book.getBookId());
			prStmt.executeUpdate();
			prStmt.close();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(prStmt);
		}
	}

	@Override
	public List<Book> bookFondReview() throws DAOException {

		PreparedStatement prStmt = null;
		ResultSet rs = null;
		Book book = null;

		List<Book> bookList = new ArrayList<>();

		try {
			prStmt = connection.prepareStatement(SHOW_ALL_BOOKS);
			rs = prStmt.executeQuery();

			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setDescription(rs.getString("description"));
				book.setBookStatus(rs.getString("status"));
				bookList.add(book);
			}

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(prStmt, rs);
		}
		return bookList;
	}

	@Override
	public void changeBookStatus(BookStatus bookStatus, int id) throws DAOException {

		PreparedStatement prStmt = null;

		try {
			prStmt = connection.prepareStatement(CHANGE_BOOK_STATUS);
			prStmt.setString(1, bookStatus.name());
			prStmt.setInt(2, id);
			prStmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(prStmt);
		}
	}

	@Override
	public void deleteBook(int id) throws DAOException {

		PreparedStatement prStmt = null;

		try {
			prStmt = connection.prepareStatement(DELETE_BOOK);
			prStmt.setInt(1, id);
			prStmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(prStmt);
		}
	}

	@Override
	public int rowCount() throws DAOException {

		PreparedStatement prStmt = null;
		ResultSet rs = null;
		int count;

		try {
			prStmt = connection.prepareStatement(ROW_COUNT);
			rs = prStmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			ConnectionManager.getManager().closeDbResources(prStmt, rs);
		}

		return count;
	}
}
