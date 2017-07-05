package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;

public class Runner {

	public static void main(String[] args) {
		
		//Properties properties = PropertyLoader.getProperties("libDB.properties");
		//DBWorker dbWorker = new DBWorker(properties);		
		Controller controller = new Controller();
		//controller.insert(dbWorker.getConnection());

		// PATTERN REQUEST                    command_book(user)_id
		//controller.executeTask("ADD_NEW_BOOK book");
		//controller.executeTask("REGISTRATION user");
		//controller.executeTask("SHOW_ALL_BOOKS book");
		//controller.executeTask("SHOW_ALL_USERS");
		//controller.executeTask("DELETE_USER 3");
		//controller.executeTask("DELETE_BOOK 7");
		controller.executeTask("REGISTRATION Tom USER X 123 ACTIVE");
	}
}
