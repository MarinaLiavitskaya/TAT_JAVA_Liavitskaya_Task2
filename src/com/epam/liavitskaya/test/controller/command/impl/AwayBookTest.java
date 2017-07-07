package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.command.impl.AwayBook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AwayBookTest {

	AwayBook awayBook;

	@Test
	public void test_execute() {
		String expected = "book is written off";
		Assert.assertEquals(awayBook.execute("AWAY_BOOK 7"), expected);
	}
	
	@Test
	public void test_execute_negative() {
		String expected = "Error during away book procedure";
		Assert.assertNotEquals(awayBook.execute("AWAY_BOOK 0"), expected);
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test_execute_negative_exception() {
		String expected = "Error during away book procedure";
		Assert.assertNotEquals(awayBook.execute("AWAY_BOOK A"), expected);
	}

	@BeforeMethod
	public void beforeMethod() {
		awayBook = new AwayBook();
	}

}
