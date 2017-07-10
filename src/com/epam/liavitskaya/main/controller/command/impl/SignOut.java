package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;
import com.epam.liavitskaya.main.util.RequestParserUtil;

public class SignOut implements Command {
	
	final Logger logger = Logger.getLogger(SignOut.class);

	@Override
	public String execute(String request) {
		
		String login = null;			
		String response = null;
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		
		try {
			String[] splitRequest = RequestParserUtil.parseRequest(request, 2);
			login = splitRequest[1];
			clientService.singOut(login);
			response = "Goodbye";
			
		} catch (ServiceException e) {
			logger.error("Error during logout procedure", e);
			response = "Error during logout procedure";
		}		
		return response;
	}
}
