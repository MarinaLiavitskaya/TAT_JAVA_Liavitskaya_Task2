package com.epam.liavitskaya.main.controller;

import com.epam.liavitskaya.main.bean.User;

public class CurrentUser {

	private static User currentUser;

	static {
		System.out.println("static block");
		CurrentUser.currentUser = new User();
		CurrentUser.getCurrentUser().setLogin("");
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		CurrentUser.currentUser = currentUser;
	}

	public static void initUser() {

		CurrentUser.currentUser = new User();
		CurrentUser.getCurrentUser().setUserId(0);
		CurrentUser.getCurrentUser().setUserName("");
		CurrentUser.getCurrentUser().setPassportNo("");
		CurrentUser.getCurrentUser().setPhone("");
		CurrentUser.getCurrentUser().setUserRole("USER");
		CurrentUser.getCurrentUser().setEmail("");
		CurrentUser.getCurrentUser().setLogin("");
		CurrentUser.getCurrentUser().setPassword("");
		CurrentUser.getCurrentUser().setUserStatus("INACTIVE");
	}
}
