package com.epam.liavitskaya.main.controller.command.impl;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class SignIn implements Command {

	@Override
	public String execute(String request) {
		
		String login = null;
		String password = null;		
		String response = null;
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		try {
			clientService.singIn(login, password);
			response = "Hi";
		} catch (ServiceException e) {
			// log
			response = "Error during login procedure";
		}
		
		return response;
	}

}
