package com.epam.liavitskaya.main.controller.command.impl;

import java.util.List;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class ShowAllUsers implements Command {

	@Override
	public String execute(String request) {

		String response = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientServiceImpl();
		try {
			List<User> showAllUsers = clientService.showAllUsers();
			response = "All users : " + showAllUsers;
		} catch (ServiceException e) {
			// log
			response = "Error during show all users procedure";
		}

		return response;
	}

}
