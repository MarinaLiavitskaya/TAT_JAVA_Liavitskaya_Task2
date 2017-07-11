package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.CurrentUser;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class EditProfile implements Command {

	final Logger logger = Logger.getLogger(EditProfile.class);

	@Override
	public String execute(String request) {

		String response = null;

		try {
			if (CurrentUser.getCurrentUser().getLogin() == null) {
				throw new ServiceException("please, sign in");
			}
			ServiceProvider serviceProvider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = serviceProvider.getClientServiceImpl();
			clientServiceImpl.editProfile(request);
			response = "profile is edited";

		} catch (ServiceException e) {
			logger.error("Error during edit profile procedure", e);
			response = "Error during edit profile procedure";
		}
		return response;
	}

}
