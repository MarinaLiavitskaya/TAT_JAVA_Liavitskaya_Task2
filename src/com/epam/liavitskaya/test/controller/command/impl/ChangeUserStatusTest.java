package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

public class ChangeUserStatusTest {

	Controller controller;

	@Test
	public void test_controller_banUser() {

		String expected = "the status of the user is changed";
		Assert.assertEquals(controller.executeTask("CHANGE_STATUS INACTIVE 3"), expected);
	}

	@Test
	public void test_banUser() {

		String expected = "the status of the user is changed";
		Assert.assertEquals(controller.executeTask("CHANGE_STATUS ACTIVE 6"), expected);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void test_banUser_negative() {

		Assert.assertNull(controller.executeTask("UNBAN_USER 5"));
	}

	@Test
	public void test_ban_negative() {

		String expected = "Error during procedure of change of the status of the user";
		Assert.assertEquals(controller.executeTask("CHANGE_STATUS ACTIVE 11"), expected);
	}

	@BeforeMethod
	public void beforeMethod() {

		controller = new Controller();
	}

}
