package com.epam.liavitskaya.main.controller.command.impl;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class AddNewBook implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryServiceImpl();
		libraryService.addNewBookService(request);
		return response;
	}

}
