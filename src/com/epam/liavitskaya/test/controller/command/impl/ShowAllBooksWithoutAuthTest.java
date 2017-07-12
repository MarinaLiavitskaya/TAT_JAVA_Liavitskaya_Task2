package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class ShowAllBooksWithoutAuthTest {

	Controller controller;

	@Test(enabled = true)
	public void test_ShowAllBooks_withoutAuth() {
		Assert.assertNotNull(controller.executeTask("SHOW_ALL_BOOKS"));
	}

	@BeforeClass
	public void beforeClass() {
		controller = new Controller();
	}

}
