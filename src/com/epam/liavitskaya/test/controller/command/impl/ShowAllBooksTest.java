package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllBooks;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ShowAllBooksTest {

	ShowAllBooks showAll;
	Controller contr;
	
	@Test
	public void test_controller_bookFondReviewService() {
		Assert.assertNotNull(contr.executeTask("SHOW_ALL_BOOKS"));
	}
	
	@Test
	public void test_bookFondReviewService() {
		Assert.assertNotNull(showAll.execute("SHOW_ALL_BOOKS"));
	}	
	
	@BeforeMethod
	public void beforeMethod() {
		contr = new Controller();
		showAll = new ShowAllBooks();
	}

}
