package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class MakeUserAdmin implements Command {

	final Logger logger = Logger.getLogger(MakeUserAdmin.class);

	@Override
	public String execute(String request) {

		String response = null;
		try {			
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = provider.getClientServiceImpl();
			clientServiceImpl.editStatus(request);
			response = "User became an administrator";
		} catch (ServiceException e) {
			logger.error("Error during make user admin procedure", e);
			response = "Error during make user admin procedure";
		}
		return response;
	}

}
