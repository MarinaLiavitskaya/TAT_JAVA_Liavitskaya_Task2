package com.epam.liavitskaya.main.controller;

import com.epam.liavitskaya.main.bean.User;

public class CurrentUser {

	private static User currentUser;

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		CurrentUser.currentUser = currentUser;
	}

}
