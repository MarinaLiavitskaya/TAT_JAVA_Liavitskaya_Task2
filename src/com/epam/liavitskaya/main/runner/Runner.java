package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.utils.ValidatorUtil;

public class Runner {

	public static void main(String[] args) {

		Controller controller = new Controller();
		
		// controller.executeTask("ADD_NEW_BOOK Harry_Potter J.K.Rowling England");			+
		//controller.executeTask("REGISTRATION Tom www123 12345 mailru USER yt2jc6wfihy7 mP1Pe6vkir11@ ACTIVE");		
		//controller.executeTask("AWAY_BOOK 7");			+
		//controller.executeTask("ORDER_BOOK 5");			+
		// PATTERN REQUEST command_book(user)_id		
		
		controller.executeTask("SHOW_ALL_BOOKS ");
		controller.executeTask("SHOW_ALL_USERS ");
		// controller.executeTask("DELETE_USER 3");
		// controller.executeTask("DELETE_BOOK 7");
		
		
		//System.out.println(ValidatorUtil.isLoginValid("tom111"));
		//System.out.println(ValidatorUtil.isPasswordValid("USERr11@"));		
		
		
	}
}
