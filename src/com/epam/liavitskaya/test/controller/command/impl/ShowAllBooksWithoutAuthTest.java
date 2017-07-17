package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

public class ShowAllBooksWithoutAuthTest {

	Controller controller;

	@Test(enabled = true, threadPoolSize = 3, invocationCount = 1, timeOut = 1000)
	public void test_ShowAllBooks_withoutAuth() {
		Assert.assertNotNull(controller.executeTask("SHOW_ALL_BOOKS"));
	}

	@Test(enabled = true)
	public void test_ShowAllAvailableBooks_withoutAuth() {
		Assert.assertNotNull(controller.executeTask("SHOW_ALL_AVAILABLE_BOOKS"));
	}

	@BeforeClass
	public void beforeClass() {
		controller = Controller.getInstance();
	}

}
