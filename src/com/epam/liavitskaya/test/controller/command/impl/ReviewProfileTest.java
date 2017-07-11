package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

public class ReviewProfileTest {

	Controller controller;

	@Test
	public void test_reviewProfile() {
		String expected = "\nUser [userName = Nick, userPassportNo = null, phone = phone222, email = email222, userRole = ADMINISTRATOR, login = xx222, userStatus = ACTIVE]";
		String actual = controller.executeTask("REVIEW_PROFILE xx222");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_reviewProfile_not_null() {
		String actual = controller.executeTask("REVIEW_PROFILE 2");
		Assert.assertNotNull(actual);
	}

	@BeforeMethod
	public void beforeMethod() {
		controller = new Controller();
	}

}
