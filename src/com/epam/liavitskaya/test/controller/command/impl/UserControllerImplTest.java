package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;

public class UserControllerImplTest {

	Controller controller;

	@Test(enabled = true)
	public void test_user_AddBook() {
		String expected = "Error during add new book procedure";
		String actual = controller.executeTask("ADD_BOOK Harry_Potter J.K.Rowling England");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_CancelOrder() {
		String expected = "Order is cancelled";
		String actual = controller.executeTask("CANCEL_ORDER 8");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_CancelOrder_negative() {
		String expected = "Error during order book procedure";
		String actual = controller.executeTask("CANCEL_ORDER 11");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_ChangeRole() {
		String expected = "Error during procedure of change of the account role";
		String actual = controller.executeTask("CHANGE_ROLE ADMINISTRATOR 5");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_ChangeStatus() {
		String expected = "Error during procedure of change of the status of the user";
		String actual = controller.executeTask("CHANGE_STATUS INACTIVE 6");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_ChangeStatus_negative() {
		String expected = "Error during procedure of change of the status of the user";
		Assert.assertEquals(controller.executeTask("CHANGE_STATUS ACTIVE 66"), expected);
	}

	@Test(enabled = true)
	public void test_user_EditBookDescription() {
		String expected = "Error during edit book description procedure";
		String actual = controller.executeTask("EDIT_BOOK_DESCRIPTION 1955_Russia, 4");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_EditBook() {
		String expected = "Error during edit book procedure";
		String actual = controller.executeTask("EDIT_BOOK THE_NORWEGIAN_WOOD HARUKI_MURAKAMI JAPAN_1987 8");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_EditProfile() {
		String expected = "profile is edited";
		String actual = controller
				.executeTask("EDIT_PROFILE 3 Molly MP2302323 25+!!59 email333 logixqrrn63 paes&wtswW43");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_MakeAdminUser() {
		String expected = "Error during procedure of change of the status of the admin";
		String actual = controller.executeTask("MAKE_ADMIN_USER USER 3");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_OrderBookService() {
		String expected = "Book is ordered";
		String actual = controller.executeTask("ORDER_BOOK 4");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_OrderBookService_negative() {
		String expected = "Error during order book procedure";
		String actual = controller.executeTask("ORDER_BOOK 0");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true, expectedExceptions = NumberFormatException.class)
	public void test_user_OrderBookService_exception() {
		controller.executeTask("ORDER_BOOK A");
	}

	@Test(enabled = true, priority = 1)
	public void test_user_Registration() {
		String expected = "Welcome";
		String actual = controller
				.executeTask("REGISTRATION DANY MP9990099 PHONE999 EMAIL999 USER xxx999 encryptT9@ ACTIVE");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_Registration_negative() {
		String expected = "Error during registration";
		String actual = controller.executeTask("REGISTRATION Tim MP1232323 12345 mail.ru USER yi7 mP1Pe6vkir11 ACTIVE");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_RreviewProfile() {
		String expected = "\nUser [userName = Nick, userPassportNo = null, phone = phone222, email = email222, userRole = ADMINISTRATOR, login = admin_login222, userStatus = ACTIVE]";
		String actual = controller.executeTask("REVIEW_PROFILE admin_login222");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_ReviewProfileById() {
		String expected = "\nUser [userName = Nick, userPassportNo = null, phone = phone222, email = email222, userRole = ADMINISTRATOR, login = admin_login222, userStatus = ACTIVE]";
		String actual = controller.executeTask("REVIEW_PROFILE_ID 2");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true)
	public void test_user_ReviewProfile_negative() {
		String expected = "Error during user profile review procedure";
		Assert.assertEquals(controller.executeTask("REVIEW_PROFILE 2"), expected);
	}

	@Test(enabled = true)
	public void test_user_ShowAllBooks() {
		Assert.assertNotNull(controller.executeTask("SHOW_ALL_BOOKS"));
	}

	@Test(enabled = true)
	public void test_user_ShowAllUsers() {
		Assert.assertNotNull(controller.executeTask("SHOW_ALL_USERS"));
	}

	@Test(enabled = true)
	public void test_user_WriteOff() {
		String expected = "Error during the procedure of write-off of the book";
		Assert.assertEquals(controller.executeTask("WRITE_OFF_BOOK 5"), expected);
	}

	@Test(enabled = true)
	public void test_user_WriteOff_negative() {
		String expected = "incorrect id";
		Assert.assertNotEquals(controller.executeTask("WRITE_OFF_BOOK 66"), expected);
	}

	@Test(enabled = true, priority = 0)
	public void test_user_Writeoff_numberFormat_negative() {
		String expected = "Error during the procedure of write-off of the book";
		Assert.assertEquals(controller.executeTask("WRITE_OFF_BOOK B"), expected);
	}

	@Test(enabled = true, priority = 0)
	public void test_user_WrongRequest_showAll() {
		String expected = "Wrong Request Format";
		String actual = controller.executeTask("SHOW_OL_USERS");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true, priority = 0)
	public void test_user_WrongRequest_writeOff() {
		String expected = "Wrong Request Format";
		Assert.assertEquals(controller.executeTask("WRITE_OFF 5"), expected);
	}

	@Test(enabled = true, priority = 2)
	public void test_user_SignIn() {
		String expected = "Hi";
		String actual = controller.executeTask("SIGN_IN xxx444 encryptT@4");
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = true, priority = 5)
	public void test_user_SignOut() {
		String expected = "Goodbye";
		String actual = controller.executeTask("SIGN_OUT xxx111");
		Assert.assertEquals(actual, expected);
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		controller = Controller.getInstance();
		controller.executeTask("SIGN_IN user_login777 encryptT@7");
	}

	@AfterClass
	public void afterClass() {

	}

}
