package com.epam.liavitskaya.test.factory;

import org.testng.annotations.Factory;

import com.epam.liavitskaya.test.controller.command.impl.AdminControllerImplTest;
import com.epam.liavitskaya.test.controller.command.impl.ShowAllBooksWithoutAuthTest;
import com.epam.liavitskaya.test.controller.command.impl.SuperAdminControllerImplTest;
import com.epam.liavitskaya.test.controller.command.impl.UserControllerImplTest;

public class FactoryTest {
	@Factory
	public Object[] factoryMethod() {
		
		return new Object[] {
				
				new ShowAllBooksWithoutAuthTest(),
				new SuperAdminControllerImplTest(),
				new AdminControllerImplTest(),
				new UserControllerImplTest()
				};
	}
}
