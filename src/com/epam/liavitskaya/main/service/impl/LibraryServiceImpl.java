package com.epam.liavitskaya.main.service.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.BookDAO;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.dao.impl.SQLBookDao;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBookService(String request) throws ServiceException {
		BookDAO bookDAO = new SQLBookDao();
		try {
			bookDAO.addBook(new Book());// !!!
		} catch (DAOException e) {
			throw new ServiceException();
		} 

	}

	@Override
	public void addEditedBookService(String request) throws ServiceException {
		BookDAO bookDAO = new SQLBookDao();
		try {
			bookDAO.editBook(new Book());
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<Book> bookFondReviewService() throws ServiceException {
		BookDAO bookDAO = new SQLBookDao();
		List<Book> bookFondReview;
		try {
			bookFondReview = bookDAO.bookFondReview();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return bookFondReview;
	}

	@Override
	public void orderBookService(String request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editBookDescriptionService(String request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeBookStatuServices(String request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBookService(String request) {
		int id = Integer.parseInt(request.substring(request.indexOf(" ") + 1, request.length()));

		BookDAO bookDAO = new SQLBookDao();
		bookDAO.deleteBook(id);

	}

}
