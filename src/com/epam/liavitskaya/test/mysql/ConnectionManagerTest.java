package com.epam.liavitskaya.test.mysql;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.mysql.ConnectionManager;

public class ConnectionManagerTest {
	
	
  @Test
  public void test_getConnection() {
	  Assert.assertNotNull(ConnectionManager.getManager().getConnection());
  }
  
  @Test
  public void test_getManager() {
	  Assert.assertNotNull(ConnectionManager.getManager());
  }
}
