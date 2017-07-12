package com.epam.liavitskaya.main.runner;

import com.epam.liavitskaya.main.controller.Controller;

public class Runner {

	public static void main(String[] args) {

		Controller controller = new Controller();
		/*
		controller.executeTask("SIGN_IN marina1991 encryptT@1991");			++
		System.out.println(CurrentUser.getCurrentUser());		
		controller.executeTask("MAKE_ADMIN_USER USER 2");		
		controller.executeTask("SIGN_OUT marina1991");
		System.out.println(CurrentUser.getCurrentUser());
		controller.executeTask("SIGN_IN marina1991 encryptT@1991");		
		controller.executeTask("MAKE_ADMIN_USER USER 1");
		*/	
		/*
		controller.executeTask("SIGN_IN marina1991 encryptT@1991");		
		controller.executeTask("ORDER_BOOK 7");		
		controller.executeTask("SIGN_OUT marina1991");
		System.out.println(controller.executeTask("ORDER_BOOK 5"));
		 */		
		//controller.executeTask("CANCEL_ORDER 7");		++	
		/*
		controller.executeTask("SIGN_IN kot0000 encryptT@0000");		
		System.out.println(controller.executeTask("ORDER_BOOK 5"));
		*/
		
		controller.executeTask("SIGN_IN marina1991 encryptT@1991");
		
		//System.out.println(controller.executeTask("WRITE_OFF 5"));
		//System.out.println(controller.executeTask("WRITE_OFF_BOOK 5"));
		
		// controller.executeTask("ADD_BOOK Harry_Potter J.K.Rowling England");``++
		// controller.executeTask("REGISTRATION Dany MP9990099 phone999 email999 USER xx909 enPcrypt9@ ACTIVE"); ++
		// controller.executeTask("WRITE_OFF_BOOK 7"); ++
	
		//String executeTask = controller.executeTask("SHOW_ALL_BOOKS"); 			 
		String executeTask = controller.executeTask("SHOW_ALL_USERS");		
		System.out.println(executeTask);
		// controller.executeTask("DELETE_USER 3"); ++
		// System.out.println(controller.executeTask("DELETE_BOOK 77")); ++
		// System.out.println(controller.executeTask("REVIEW_PROFILE xx333"));
		 //System.out.println(controller.executeTask("REVIEW_PROFILE_ID 3"));
		// System.out.println(controller.executeTask("EDIT_PROFILE 3 Molly MP2302323 25+!!59 email333 logixqrrn63 paes&wtswW43"));	++
		// controller.executeTask("EDIT_BOOK The_Norwegian_Wood Haruki_Murakami Japan_1987 8");			++
		// System.out.println(controller.executeTask("CHANGE_STATUS INACTIVE 5")); ++
		// controller.executeTask("CHANGE_ROLE SUPERADMINISTRATOR -2"); ++
		// controller.executeTask("CHANGE_ROLE USER -3"); ++		
		// System.out.println(controller.executeTask("REVIEW_PROFILE 1"));		++
	}
}
