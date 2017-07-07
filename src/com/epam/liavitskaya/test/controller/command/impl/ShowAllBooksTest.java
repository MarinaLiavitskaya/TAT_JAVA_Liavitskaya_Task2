package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.command.impl.ShowAllBooks;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ShowAllBooksTest {

	ShowAllBooks showAll;

	@Test
	public void test_bookFondReviewService() {
		Assert.assertNotNull(showAll.execute("SHOW_ALL_BOOKS"));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		showAll = new ShowAllBooks();
	}

}
