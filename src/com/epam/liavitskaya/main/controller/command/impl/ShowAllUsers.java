package com.epam.liavitskaya.main.controller.command.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.controller.CurrentUser;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.enumeration.UserRoles;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class ShowAllUsers implements Command {

	final Logger logger = Logger.getLogger(ShowAllUsers.class);

	@Override
	public String execute(String request) {

		String response = null;

		try {
			if (UserRoles.UNAUTHORIZED.name().equals(CurrentUser.getCurrentUser().getUserRole())) {
				throw new ServiceException("you have no permission for this operation");
			}
			if (UserRoles.USER.name().equals(CurrentUser.getCurrentUser().getUserRole())) {
				throw new ServiceException("you have no permission for this operation");
			}
			ServiceProvider serviceProvider = ServiceProvider.getInstance();
			ClientService clientService = serviceProvider.getClientServiceImpl();
			List<User> showAllUsers = clientService.showAllUsers();
			response = "All users : " + showAllUsers;

		} catch (ServiceException e) {
			logger.error("Error during show all users procedure", e);
			response = "Error during show all users procedure";
		}

		return response;
	}

}
