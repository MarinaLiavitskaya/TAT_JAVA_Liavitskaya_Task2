package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;

public class Runner {

	public static void main(String[] args) {

		Controller controller = Controller.getInstance();

		controller.executeTask("SIGN_IN superadmin1991 encryptT@1991");
		controller.executeTask("ORDER_BOOK 8");
		controller.executeTask("EDIT_PROFILE 3 Molly MP2302323 +2599959 email333 logixqrrn63 paes&wtswW43");
		controller.executeTask("ADD_BOOK Harry_Potter J.K.Rowling England");

		controller.executeTask("WRITE_OFF_BOOK 9");
		controller.executeTask("MAKE_ADMIN_USER USER 1");
		controller.executeTask("WRITE_OFF_BOOK 8");
		controller.executeTask("ADD_BOOK Harry_Potter_3 J.K.Rowling England");
		controller.executeTask("ADD_BOOK Harry_Potter_5 J.K.Rowling England");

		/*
		 * controller.executeTask("SIGN_IN marina1991 encryptT@1991"); ++
		 * controller.executeTask("MAKE_ADMIN_USER USER 2");
		 * controller.executeTask("SIGN_OUT marina1991");
		 * controller.executeTask("SIGN_IN marina1991 encryptT@1991");
		 * controller.executeTask("MAKE_ADMIN_USER USER 1");
		 */
		/*
		 * controller.executeTask("SIGN_IN marina1991 encryptT@1991");
		 * controller.executeTask("ORDER_BOOK 7");
		 * controller.executeTask("SIGN_OUT marina1991");
		 */
		// controller.executeTask("CANCEL_ORDER 7"); ++			
		// controller.executeTask("WRITE_OFF_BOOK 7"); ++
		// controller.executeTask("DELETE_USER 3"); ++
		// controller.executeTask("EDIT_BOOK The_Norwegian_Wood Haruki_Murakami Japan_1987 8"); ++
		// System.out.println(controller.executeTask("CHANGE_STATUS INACTIVE
		// 5")); ++
		// controller.executeTask("CHANGE_ROLE SUPERADMINISTRATOR -2"); ++
		// controller.executeTask("CHANGE_ROLE USER -3"); ++
	}
}
