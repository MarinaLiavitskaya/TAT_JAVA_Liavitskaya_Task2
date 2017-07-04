package com.epam.liavitskaya.main.controller.command.impl;

import com.epam.liavitskaya.main.bean.User;
import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class Registration implements Command {

		@Override
		public String execute(String request) {		
				
			String response = null;
			
			ServiceProvider serviceProvider = ServiceProvider.getInstance();
			ClientService clientService = serviceProvider.getClientServiceImpl();
			User user = new User();
			clientService.registration(user);
			
			return response;
		}

}
