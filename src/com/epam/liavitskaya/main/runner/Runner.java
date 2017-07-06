package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.utils.ValidatorUtil;

public class Runner {

	public static void main(String[] args) {

		Controller controller = new Controller();

		// PATTERN REQUEST command_book(user)_id
		// controller.executeTask("ADD_NEW_BOOK book");
		// controller.executeTask("REGISTRATION user");
		// controller.executeTask("SHOW_ALL_BOOKS book");
		// controller.executeTask("SHOW_ALL_USERS");
		// controller.executeTask("DELETE_USER 3");
		// controller.executeTask("DELETE_BOOK 7");
		System.out.println(ValidatorUtil.isLoginValid("tom111"));
		System.out.println(ValidatorUtil.isPasswordValid("USERr11@"));

		controller.executeTask("REGISTRATION Tom USER tom111 USERr11@ ACTIVE");

		System.out.println(ValidatorUtil.isLoginValid("qwe3_"));
		System.out.println(ValidatorUtil.isPasswordValid("qwerfA12@"));
	}
}
