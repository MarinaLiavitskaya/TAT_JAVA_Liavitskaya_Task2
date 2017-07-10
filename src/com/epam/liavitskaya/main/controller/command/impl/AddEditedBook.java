package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class AddEditedBook implements Command {
	
	final Logger logger = Logger.getLogger(AddEditedBook.class);

	@Override
	public String execute(String request) {

		String response = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryServiceImpl();
		
		try {
			libraryService.addEditedBookService(request);
			response = "Edited book is added";
			
		} catch (ServiceException e) {
			logger.error("Error during add edited book procedure", e);
			response = "Error during add edited book procedure";
		}
		return response;
	}
}
