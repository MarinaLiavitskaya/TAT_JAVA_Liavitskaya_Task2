package com.epam.liavitskaya.test.dao.worker;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.dao.worker.DBWorker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;

public class JDBCExampleTest {
	DBWorker dbWorker;
  @Test
  public void test_getConnection() {
	 assertNotNull(dbWorker.getConnection());
  }
  @BeforeMethod
  public void beforeMethod() {
	  dbWorker = new DBWorker("jdbc:mysql://localhost:3306/", "library", "root", "root");
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
