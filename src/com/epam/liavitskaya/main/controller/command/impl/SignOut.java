package com.epam.liavitskaya.main.controller.command.impl;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class SignOut implements Command {

	@Override
	public String execute(String request) {
		
		String login = null;			
		String response = null;
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		clientService.singOut(login);
		
		return response;
	}
}