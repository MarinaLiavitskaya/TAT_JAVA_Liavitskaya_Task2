package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

public class RegistrationTest {

	Controller controller;

	@Test
	public void test_registration_execute() {

		String expectedResponse = "Welcome";
		String actualResponse = controller
				.executeTask("REGISTRATION Tom www123 12345 mailru USER ert89 wertyUR3@ ACTIVE");
		Assert.assertEquals(actualResponse, expectedResponse);
	}

	@Test
	public void test_registration_execute_negative() {

		String expectedResponse = "Welcome";
		String actualResponse = controller
				.executeTask("REGISTRATION Tom MP1232323 12345 mail.ru USER yi7 mP1Pe6vkir11 ACTIVE");
		Assert.assertNotEquals(actualResponse, expectedResponse);
	}

	@BeforeMethod
	public void beforeMethod() {
		controller = new Controller();
	}

}
