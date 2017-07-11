package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class ReviewProfileById implements Command {

	final Logger logger = Logger.getLogger(ReviewProfileById.class);

	@Override
	public String execute(String request) {
		
		String response = null;

		try {
			ServiceProvider serviceProvider = ServiceProvider.getInstance();
			ClientService clientService = serviceProvider.getClientServiceImpl();
			User user = clientService.reviewProfileById(request);
			response = user.toString();

		} catch (ServiceException e) {
			logger.error("Error during user profile review by id procedure", e);
			response = "Error during user profile review by id procedure";
		}
		return response;
	}

}
