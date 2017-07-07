package com.epam.liavitskaya.test.controller.command.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.command.impl.AddNewBook;

public class AddNewBookTest {
	AddNewBook addBook;
	
  @Test
  public void test_AddNewBookService() {
	  String expectedResponse = "New book is added";
	  String actualResponse = addBook.execute("ADD_NEW_BOOK Harry_Potter J.K.Rowling England");
	  Assert.assertEquals(actualResponse, expectedResponse);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  addBook  = new AddNewBook();
  }  


}
