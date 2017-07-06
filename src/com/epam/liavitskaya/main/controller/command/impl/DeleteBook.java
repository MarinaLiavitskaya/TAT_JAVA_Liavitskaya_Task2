package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class DeleteBook implements Command {

	final Logger logger = Logger.getLogger(DeleteBook.class);
	
	@Override
	public String execute(String request) {

		String response = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryServiceImpl();
		try {
			libraryService.deleteBookService(request);
			response = "Book is deleted";
		} catch (ServiceException e) {
			logger.error("Error during delete book procedure", e);
			response = "Error during delete book procedure";
		}
		return response;
	}
}
