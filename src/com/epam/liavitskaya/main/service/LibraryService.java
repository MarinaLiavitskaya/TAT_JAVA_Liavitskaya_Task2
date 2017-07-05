package com.epam.liavitskaya.main.service;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.service.exception.ServiceException;

public interface LibraryService {

	void addNewBookService(String request) throws ServiceException; // add

	void addEditedBookService(String request) throws ServiceException; // edit

	List<Book> bookFondReviewService() throws ServiceException; // select

	void orderBookService(String request) throws ServiceException;

	void editBookDescriptionService(String request) throws ServiceException;

	void changeBookStatuServices(String request) throws ServiceException; // update

	void deleteBookService(String request) throws ServiceException; // delete

}
