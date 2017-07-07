package com.epam.liavitskaya.main.service.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.BookDAO;
import com.epam.liavitskaya.main.dao.exception.DAOException;
import com.epam.liavitskaya.main.dao.impl.SQLBookDao;
import com.epam.liavitskaya.main.enums.BookStatus;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.utils.RequestParserUtil;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBookService(String request) throws ServiceException {
		BookDAO bookDAO = new SQLBookDao();
		String[] parseRequest = RequestParserUtil.parseRequest(request, 4);
		try {
			bookDAO.addBook(new Book(parseRequest[1], parseRequest[2], parseRequest[3], BookStatus.AVAILABLE));
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
	public void orderBookService(String request) throws ServiceException {
		String idStr = request.substring(request.indexOf(" ") + 1, request.length());	
		int id = Integer.parseInt(idStr);		
		BookDAO bookDAO = new SQLBookDao();
		try {
			bookDAO.changeBookStatus(BookStatus.ORDERED, id);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void editBookDescriptionService(String request) throws ServiceException {
		String idStr = request.substring(request.indexOf(" ") + 1 , request.length());
		int id = Integer.parseInt(idStr);
		System.out.println(id);
		BookDAO bookDAO = new SQLBookDao();
		Book book = new Book();          
		try {
			bookDAO.editBook(book);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void changeBookStatusServices(String request) throws ServiceException {
		String idStr = request.substring(request.indexOf(" ") + 1, request.length());	
		int id = Integer.parseInt(idStr);		
		BookDAO bookDAO = new SQLBookDao();
		try {
			bookDAO.changeBookStatus(BookStatus.NONRECOVERABLE, id);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void deleteBookService(String request) throws ServiceException {
		int id = Integer.parseInt(request.substring(request.indexOf(" ") + 1, request.length()));
		BookDAO bookDAO = new SQLBookDao();
		try {
			bookDAO.deleteBook(id);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

}
