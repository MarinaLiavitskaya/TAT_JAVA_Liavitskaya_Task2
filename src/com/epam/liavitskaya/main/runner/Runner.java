package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;

public class Runner {

	public static void main(String[] args) {

		Controller controller = new Controller();
		
		// controller.executeTask("ADD_NEW_BOOK Harry_Potter J.K.Rowling England");			+
		//controller.executeTask("REGISTRATION Tom www123 12345 mailru USER yt2jc6wfihy7 mP1Pe6vkir11@ ACTIVE");		
		//controller.executeTask("AWAY_BOOK 7");			+
		//controller.executeTask("ORDER_BOOK 5");			+				
		//String executeTask2 = controller.executeTask("SHOW_ALL_BOOKS ");		+
		//String executeTask = controller.executeTask("SHOW_ALL_USERS ");		+
		//controller.executeTask("DELETE_USER 3");								+
		//controller.executeTask("DELETE_BOOK 7");								+
		//System.out.println(controller.executeTask("REVIEW_PROFILE 2"));			+
		//System.out.println(controller.executeTask("EDIT_PROFILE 3 Molly MP2302323 2595959 email333 login passw3"));		+
		//System.out.println(controller.executeTask("BAN_USER 5"));
		controller.executeTask("MAKE_USER_ADMIN ADMIN 2");
		controller.executeTask("MAKE_ADMIN_USER USER 3");
		//System.out.println(ValidatorUtil.isLoginValid("tom111"));
		//System.out.println(ValidatorUtil.isPasswordValid("USERr11@"));		
		
		
	}
}
