package com.epam.liavitskaya.main.controller.command.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class Registration implements Command {

	final Logger logger = Logger.getLogger(Registration.class);

	@Override
	public String execute(String request) {

		String response = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		try {
			clientService.registration(request);
			response = "Welcome";
		} catch (ServiceException e) {
			logger.debug("Error during registration", e);
			response = "Error during registration";
		}
		return response;
	}

	public boolean isPasswordOriginal(String password) {

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		List<String> fetchAllPasswords = null;
		try {
			fetchAllPasswords = clientService.fetchAllPasswords();
		} catch (ServiceException e) {
			logger.debug("Error during is Password Original check", e);
			e.printStackTrace();
		}
		return fetchAllPasswords.contains(password);
	}

	public boolean isLoginOriginal(String login) {

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		List<String> fetchAllLoginss = null;
		try {
			fetchAllLoginss = clientService.fetchAllLogins();
		} catch (ServiceException e) {
			logger.debug("Error during is Login Original check", e);
			e.printStackTrace();
		}		
		return fetchAllLoginss.contains(login);
	}

}
