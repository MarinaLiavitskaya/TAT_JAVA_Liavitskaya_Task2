package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.command.impl.ShowAllUsers;

public class ShowAllUsersTest {

	ShowAllUsers showAll;

	@Test
	public void test_showAllUsers() {
		Assert.assertNotNull(showAll.execute("SHOW_ALL_USERS"));
	}

	@BeforeMethod
	public void beforeMethod() {
		showAll = new ShowAllUsers();
	}

}
