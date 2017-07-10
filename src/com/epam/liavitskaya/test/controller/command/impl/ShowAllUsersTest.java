package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllUsers;

public class ShowAllUsersTest {

	ShowAllUsers showAll;
	Controller contr;

	@Test
	public void test_controller_showAllUsers() {
		Assert.assertNotNull(contr.executeTask("SHOW_ALL_USERS"));
	}
	
	@Test
	public void test_showAllUsers() {
		Assert.assertNotNull(showAll.execute("SHOW_ALL_USERS"));
	}

	@BeforeMethod
	public void beforeMethod() {
		showAll = new ShowAllUsers();
		contr = new Controller();
	}

}
