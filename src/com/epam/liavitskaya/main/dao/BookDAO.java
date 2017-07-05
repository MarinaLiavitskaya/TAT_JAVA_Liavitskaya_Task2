package com.epam.liavitskaya.main.dao;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.enums.BookStatus;

public interface BookDAO {

	void addBook(Book book) throws DAOException;
	void editBook(Book book) throws DAOException;
	List<Book> bookFondReview() throws DAOException;
	void changeBookStatus(BookStatus bookStatus, int bookId) throws DAOException;
	void deleteBook(int bookId) throws DAOException;
	void delete() throws DAOException;
}
