package com.epam.liavitskaya.main.controller.command.impl;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class Registration implements Command {

	@Override
	public String execute(String request) {

		String response = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		try{
		clientService.registration(request);
		response = "Welcome";
		}catch (ServiceException e) {
			// log
			response = "Error during registration";
		}
		return response;
	}

}
