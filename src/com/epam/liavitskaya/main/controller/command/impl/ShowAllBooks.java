package com.epam.liavitskaya.main.controller.command.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class ShowAllBooks implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryServiceImpl();
		try {
			List<Book> bookFondReview = libraryService.bookFondReviewService();
			response = "Check here books of fund : " + bookFondReview;
		} catch (ServiceException e) {
			// log
			response = "Error during show all books procedure";
		}
		return response;
	}

}
