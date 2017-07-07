package com.epam.liavitskaya.main.controller.command.impl;

import org.apache.log4j.Logger;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;
import com.epam.liavitskaya.main.utils.RequestParserUtil;

public class DeleteUser implements Command {

	final Logger logger = Logger.getLogger(DeleteUser.class);

	@Override
	public String execute(String request) {

		String response = null;
		try {
			String[] parseRequest = RequestParserUtil.parseRequest(request, 2);
			int id = Integer.parseInt(parseRequest[1]);
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService clientServiceImpl = provider.getClientServiceImpl();

			clientServiceImpl.deleteUser(id);
			response = "User is deleted";
		} catch (ServiceException e) {
			logger.error("Error during delete user procedure", e);
			response = "Error during delete user procedure";
		}

		return response;
	}
}
