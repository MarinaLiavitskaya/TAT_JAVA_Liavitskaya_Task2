package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class WriteOffBook implements Command {

	final Logger logger = Logger.getLogger(WriteOffBook.class);

	@Override
	public String execute(String request) {

		String response = null;

		try {
			ServiceProvider serviceProvider = ServiceProvider.getInstance();
			LibraryService libraryService = serviceProvider.getLibraryServiceImpl();
			libraryService.writeOffBookService(request);
			response = "book is written off";

		} catch (ServiceException e) {
			logger.error("Error during the procedure of write-off of the book", e);
			response = "Error during the procedure of write-off of the book";
		}
		return response;
	}
}
