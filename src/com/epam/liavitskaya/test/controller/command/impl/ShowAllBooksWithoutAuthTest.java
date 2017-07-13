package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.server.Server;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class ShowAllBooksWithoutAuthTest {

	Controller controller;
	Server server;

	@Test(enabled = true, threadPoolSize = 5, invocationCount = 10, timeOut = 1000)
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
		server = new Server();
	}

}
