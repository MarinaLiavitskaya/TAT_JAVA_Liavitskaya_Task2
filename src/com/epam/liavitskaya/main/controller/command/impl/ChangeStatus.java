package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.CurrentUser;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class ChangeStatus implements Command {

	final Logger logger = Logger.getLogger(ChangeStatus.class);

	@Override
	public String execute(String request) {

		String response = null;

		try {
			if (CurrentUser.getCurrentUser().getUserRole() == UserRoles.USER.name()) {
				throw new ServiceException("you have no permission for this operation");
			}
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = provider.getClientServiceImpl();
			clientServiceImpl.editStatus(request);
			response = "The status of the user is changed";

		} catch (ServiceException e) {
			logger.error("Error during procedure of change of the status of the user", e);
			response = "Error during procedure of change of the status of the user";
		}
		return response;
	}

}