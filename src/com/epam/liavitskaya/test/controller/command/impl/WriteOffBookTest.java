package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

public class WriteOffBookTest {

	Controller controller;

	@Test
	public void test_execute() {
		String expected = "book is written off";
		Assert.assertEquals(controller.executeTask("WRITE_OFF_BOOK 7"), expected);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void test_writeoff_illegal_negative() {
		String expected = "Error during the procedure of write-off of the book";
		Assert.assertNotEquals(controller.executeTask("WRITE_OFF 5"), expected);
	}
	
	@Test
	public void test_writeoff_negative() {
		String expected = "incorrect id";
		Assert.assertNotEquals(controller.executeTask("WRITE_OFF_BOOK 66"), expected);
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void test_writeoff_numberformat_negative() {
		String expected = "Error during the procedure of write-off of the book";
		Assert.assertNotEquals(controller.executeTask("WRITE_OFF_BOOK A"), expected);
	}

	@BeforeMethod
	public void beforeMethod() {
		controller = new Controller();
	}

}
