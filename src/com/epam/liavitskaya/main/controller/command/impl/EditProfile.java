package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class EditProfile implements Command {

	final Logger logger = Logger.getLogger(EditProfile.class);

	@Override
	public String execute(String request) {
		String response = null;
			
		User user = new User();		// !!!
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		try {
			ClientService clientServiceImpl = serviceProvider.getClientServiceImpl();
			clientServiceImpl.editProfile(user);
			response = "profile is edited";
		} catch (ServiceException e) {
			logger.error("Error during edit profile procedure", e);
			response = "Error during edit profile procedure";
		}
		return response;
	}

}
