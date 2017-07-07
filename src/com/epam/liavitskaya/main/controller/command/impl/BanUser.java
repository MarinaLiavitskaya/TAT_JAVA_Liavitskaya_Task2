package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class BanUser implements Command {

	final Logger logger = Logger.getLogger(BanUser.class);

	@Override
	public String execute(String request) {

		String response = null;
		try {			
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = provider.getClientServiceImpl();
			clientServiceImpl.editStatus(request);
			response = "User is banned";
		} catch (ServiceException e) {
			logger.error("Error during ban user procedure", e);
			response = "Error during ban user procedure";
		}
		return response;
	}	

}
