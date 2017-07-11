package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.CurrentUser;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class EditBookDescription implements Command {

	final Logger logger = Logger.getLogger(EditBookDescription.class);

	@Override
	public String execute(String request) {
		
		String response = null;
		
		try {
			if (CurrentUser.getCurrentUser().getUserRole() == UserRoles.USER.name()) {
				throw new ServiceException("you have no permission for this operation");
			}
			ServiceProvider serviceProvider = ServiceProvider.getInstance();
			LibraryService libraryService = serviceProvider.getLibraryServiceImpl();
			libraryService.editBookDescriptionService(request);
			response = "Book description is edited";
			
		} catch (ServiceException e) {
			logger.error("Error during edit book description procedure", e);
			response = "Error during edit book description procedure";
		}
		return response;
	}

}