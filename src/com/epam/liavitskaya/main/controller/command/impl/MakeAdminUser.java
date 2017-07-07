package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class MakeAdminUser implements Command {

	final Logger logger = Logger.getLogger(MakeAdminUser.class);

	@Override
	public String execute(String request) {

		String response = null;
		try {			
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = provider.getClientServiceImpl();
			clientServiceImpl.editStatus(request);
			response = "Admin became a user";
		} catch (ServiceException e) {
			logger.error("Error during make admin user procedure", e);
			response = "Error during make admin user procedure";
		}
		return response;
	}

}
