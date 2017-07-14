package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.server.Server;

public class Runner {

	public static void main(String[] args) {

		Controller controller = Controller.getInstance();				// один контроллер - один юзер
		controller.executeTask("SIGN_IN superadmin1991 encryptT@1991");
		// server.initServer("REVIEW_PROFILE_ID 1,REVIEW_PROFILE_ID
		// 1,REVIEW_PROFILE_ID 1,REVIEW_PROFILE_ID 1,REVIEW_PROFILE_ID
		// 1,REVIEW_PROFILE_ID 1,REVIEW_PROFILE_ID 1,REVIEW_PROFILE_ID 1");
		// server.syntheticinitServer("REVIEW_PROFILE_ID 1");
		Server server = new Server();
		server.initServer("ORDER_BOOK 8");
		server.initServer("REVIEW_PROFILE_ID 8");
		server.initServer("REVIEW_PROFILE jake0000");
		server.initServer("EDIT_PROFILE 3 Molly MP2302323 25+###59 email333 logixqrrn63 paes&wtswW43");
		server.initServer("EDIT_BOOK The_Norwegian_Wood Haruki_Murakami Japan_1987 9");
		server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		server.initServer("ADD_BOOK Harry_Potter J.K.Rowling England");
		server.initServer("WRITE_OFF_BOOK 9");
		server.initServer("MAKE_ADMIN_USER USER 1");
		// server.initServer("WRITE_OFF_BOOK 8");
		// server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		server.initServer("ADD_BOOK Harry_Potter_2 J.K.Rowling England");
		// server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		// server.initServer("ADD_BOOK Harry_Potter_3 J.K.Rowling England");
		 server.initServer("REVIEW_PROFILE_ID 1");
		// server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		 server.initServer("ADD_BOOK Harry_Potter_4 J.K.Rowling England");
		// server.initServer("ADD_BOOK Harry_Potter_5 J.K.Rowling England");
		 server.initServer("ADD_BOOK Harry_Potter_6 J.K.Rowling England");

		/*
		 * controller.executeTask("SIGN_IN marina1991 encryptT@1991"); ++
		 * System.out.println(CurrentUser.getCurrentUser());
		 * controller.executeTask("MAKE_ADMIN_USER USER 2");
		 * controller.executeTask("SIGN_OUT marina1991");
		 * System.out.println(CurrentUser.getCurrentUser());
		 * controller.executeTask("SIGN_IN marina1991 encryptT@1991");
		 * controller.executeTask("MAKE_ADMIN_USER USER 1");
		 */
		/*
		 * controller.executeTask("SIGN_IN marina1991 encryptT@1991");
		 * controller.executeTask("ORDER_BOOK 7");
		 * controller.executeTask("SIGN_OUT marina1991");
		 * System.out.println(controller.executeTask("ORDER_BOOK 5"));
		 */
		// controller.executeTask("CANCEL_ORDER 7"); ++
		/*
		 * controller.executeTask("SIGN_IN kot0000 encryptT@0000");
		 * System.out.println(controller.executeTask("ORDER_BOOK 5"));
		 */
		// controller.executeTask("CANCEL_ORDER 10");
		// System.out.println(controller.executeTask("WRITE_OFF 5"));
		// System.out.println(controller.executeTask("WRITE_OFF_BOOK 5"));
		// controller.executeTask("SIGN_IN superadmin1991 encryptT@1991");
		// String executeTask =
		// controller.executeTask("SHOW_ALL_AVAILABLE_BOOKS");
		// System.out.println(executeTask);
		// controller.executeTask("ADD_BOOK Harry_Potter J.K.Rowling
		// England");``++
		// controller.executeTask("REGISTRATION Dany MP9990099 phone999 email999
		// USER xx909 enPcrypt9@ ACTIVE"); ++
		// controller.executeTask("WRITE_OFF_BOOK 7"); ++
		// String executeTask = controller.executeTask("SHOW_ALL_BOOKS");
		// String executeTask = controller.executeTask("SHOW_ALL_USERS");
		// System.out.println(executeTask);
		// controller.executeTask("DELETE_USER 3"); ++
		// System.out.println(controller.executeTask("DELETE_BOOK 77")); ++
		// System.out.println(controller.executeTask("REVIEW_PROFILE xx333"));
		// System.out.println(controller.executeTask("REVIEW_PROFILE_ID 3"));
		// System.out.println(controller.executeTask("EDIT_PROFILE 3 Molly
		// MP2302323 25+!!59 email333 logixqrrn63 paes&wtswW43")); ++
		// controller.executeTask("EDIT_BOOK The_Norwegian_Wood Haruki_Murakami
		// Japan_1987 8"); ++
		// System.out.println(controller.executeTask("CHANGE_STATUS INACTIVE
		// 5")); ++
		// controller.executeTask("CHANGE_ROLE SUPERADMINISTRATOR -2"); ++
		// controller.executeTask("CHANGE_ROLE USER -3"); ++
		// System.out.println(controller.executeTask("REVIEW_PROFILE 1")); ++
	}
}
