package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class DeleteUser implements Command {

	final Logger logger = Logger.getLogger(DeleteUser.class);

	@Override
	public String execute(String request) {

		String response = null;
		try {
						
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = provider.getClientServiceImpl();

			clientServiceImpl.deleteUser(request);
			response = "User is deleted";
		} catch (ServiceException e) {
			logger.error("Error during procedure of delete of the user", e);
			response = "Error during procedure of delete of the user";
		}

		return response;
	}
}
