package com.epam.liavitskaya.test.dao.worker;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.dao.worker.JDBCExample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;

public class JDBCExampleTest {
  @Test
  public void test_getConnection() {
	  assertNotNull(JDBCExample.getConnection());
  }
  @BeforeMethod
  public void beforeMethod() {
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
