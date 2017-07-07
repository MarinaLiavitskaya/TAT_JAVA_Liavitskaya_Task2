package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.controller.command.impl.BanUser;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class BanUserTest {

	BanUser banUser;
	Controller con;

	@Test
	public void test_controller_banUser() {
		String expected = "User is banned";
		Assert.assertEquals(con.executeTask("BAN_USER 5"), expected);
	}
	
	@Test
	public void test_banUser() {
		String expected = "User is banned";
		Assert.assertEquals(banUser.execute("BAN_USER 4"), expected);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void test_banUser_negative() {
		Assert.assertNull(con.executeTask("UNBAN_USER 5"));
	}

	@BeforeMethod
	public void beforeMethod() {
		banUser = new BanUser();
		con = new Controller();
	}

}
