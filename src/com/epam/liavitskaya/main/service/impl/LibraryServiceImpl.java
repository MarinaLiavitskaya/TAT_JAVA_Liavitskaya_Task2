package com.epam.liavitskaya.main.service.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.dao.BookDAO;
import com.epam.liavitskaya.main.dao.impl.SQLBookDao;
import com.epam.liavitskaya.main.service.LibraryService;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBookService(String request) {
		BookDAO bookDAO = new SQLBookDao();
		bookDAO.addBook();
		
	}
	
	@Override
	public void addEditedBookService(String request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> bookFondReviewService() {
		BookDAO bookDAO = new SQLBookDao();
		bookDAO.bookFondReview();
		return null;
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
		// TODO Auto-generated method stub
		
	}

}
