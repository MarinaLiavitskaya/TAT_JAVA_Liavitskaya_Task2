package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.command.impl.ReviewProfile;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ReviewProfileTest {

	ReviewProfile profile;

	@Test
	public void test_reviewProfile() {
		String expected = "User [userName = Nick, userPassportNo = null, phone = phone222, email = email222, userRole = USER, login = xx222, userStatus = ACTIVE]";
		String actual = profile.execute("REVIEW_PROFILE 2");
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_reviewProfile_not_null() {		
		String actual = profile.execute("REVIEW_PROFILE 2");
		Assert.assertNotNull(actual);
	}

	@BeforeMethod
	public void beforeMethod() {
		profile = new ReviewProfile();
	}

}
