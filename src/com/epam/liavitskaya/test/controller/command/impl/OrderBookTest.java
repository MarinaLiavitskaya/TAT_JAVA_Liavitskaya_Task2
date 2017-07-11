package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.controller.command.impl.OrderBook;

public class OrderBookTest {
	
	Controller controller;

	@Test
	public void test_orderBookService() {
		String expected = "Book is ordered";
		Assert.assertEquals(controller.executeTask("ORDER_BOOK 4"), expected);;
	}
	
	@Test
	public void test_orderBookService_negative() {
		String expected = "Error during away book procedure";
		Assert.assertNotEquals(controller.executeTask("ORDER_BOOK 0"), expected);
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test_orderBookService_exception() {
		String expected = "Error during away book procedure";
		Assert.assertNotEquals(controller.executeTask("ORDER_BOOK A"), expected);
	}

	@BeforeMethod
	public void beforeMethod() {
		controller = new Controller();
	}
}
