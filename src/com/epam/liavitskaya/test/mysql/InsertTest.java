package com.epam.liavitskaya.test.mysql;

import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllBooks;
import com.epam.liavitskaya.main.controller.command.impl.ShowAllUsers;
import com.epam.liavitskaya.main.mysql.ConnectionManager;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.LibraryService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.impl.ClientServiceImpl;
import com.epam.liavitskaya.main.service.impl.LibraryServiceImpl;

import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class InsertTest {

	Connection connection;
	PreparedStatement preparedStatement;

	ShowAllUsers users;
	ShowAllBooks books;
	Controller controller;
	ClientService clientImpl;
	LibraryService libImpl;

	final static String USERS_INSERT_01 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Tom', 'MP1110011', 'phone111', 'email111', 'SUPERADMINISTRATOR', 'xx111', 'encryptT@1', 'ACTIVE')";
	final static String USERS_INSERT_02 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Nick', 'MP2220022', 'phone222', 'email222', 'ADMINISTRATOR', 'xx222', 'encryptT@2', 'ACTIVE')";
	final static String USERS_INSERT_03 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Molly', 'MP3330033', 'phone333', 'email333', 'ADMINISTRATOR', 'xx333', 'encryptT@3', 'ACTIVE')";
	final static String USERS_INSERT_04 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Kate', 'MP4440044', 'phone444', 'email444', 'USER', 'xx444', 'encryptT@4', 'ACTIVE')";
	final static String USERS_INSERT_05 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Paul', 'MP5550055', 'phone555', 'email555', 'USER', 'xx555', 'encryptT@5', 'ACTIVE')";
	final static String USERS_INSERT_06 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Jane', 'MP6660066', 'phone666', 'email666', 'USER', 'xx666', 'encryptT@6', 'ACTIVE')";
	final static String USERS_INSERT_07 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Bob', 'MP7770077', 'phone777', 'email777', 'USER', 'xx777', 'encryptT@7', 'ACTIVE')";
	final static String USERS_INSERT_08 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Ann', 'MP8880088', 'phone888', 'email888', 'USER', 'xx888', 'encryptT@8', 'INACTIVE')";
	final static String USERS_INSERT_09 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Marina', 'MP2306723', '7781991', 'email1991', 'ADMINISTRATOR', 'marina1991', 'encryptT@1991', 'ACTIVE')";
	final static String USERS_INSERT_10 = "INSERT INTO `users`(name, passport, phone, email, role, login, password, status) VALUES('Jake', 'MP0000000', '0000000', 'email0000', 'ADMINISTRATOR', 'jake0000', 'encryptT@0000', 'INACTIVE')";

	final static String BOOKS_INSERT_01 = "INSERT INTO `books`(title, author, description, status, user_id) VALUES('Cien años de soledad', 'Gabriel García Márquez', 'Spain', 'ON_HAND', 9)";
	final static String BOOKS_INSERT_02 = "INSERT INTO `books`(title, author, description, status, user_id) VALUES('Moby-Dick', 'Herman Melville', '1851_USA', 'ORDERED', 6)";
	final static String BOOKS_INSERT_03 = "INSERT INTO `books`(title, author, description, status, user_id) VALUES('Nineteen Eighty-Four', 'George Orwell', '1849_UK', 'ORDERED', 9)";
	final static String BOOKS_INSERT_04 = "INSERT INTO `books`(title, author, description, status, user_id) VALUES('The Great Gatsby', 'F.Scott Fitzgerald', '1925_USA', 'WRITTEN_OFF', 4)";
	final static String BOOKS_INSERT_05 = "INSERT INTO `books`(title, author, description, status) VALUES('Lolita', 'Vladimir Nabokov', 'Russia', 'AVAILABLE')";
	final static String BOOKS_INSERT_06 = "INSERT INTO `books`(title, author, description, status, user_id) VALUES('Madame Bovary', 'Gustave Flaubert', '1856_France', 'ON_HAND', 2);";
	final static String BOOKS_INSERT_07 = "INSERT INTO `books`(title, author, description, status) VALUES('Great Expectation', 'Charles Dickens', 'England', 'AVAILABLE')";
	final static String BOOKS_INSERT_08 = "INSERT INTO `books`(title, author, description, status) VALUES('Brave New Worldn', 'Aldous Huxley', 'England', 'AVAILABLE')";
	final static String BOOKS_INSERT_09 = "INSERT INTO `books`(title, author, description, status) VALUES('Norwegian Wood', 'Haruki Murakami', '1987_Japan', 'AVAILABLE')";
	final static String BOOKS_INSERT_10 = "INSERT INTO `books`(title, author, description, status) VALUES('The Hobbit, or There and Back Again', 'J.R.R.Tolkien', '1937 UK', 'AVAILABLE')";
	final static String BOOKS_INSERT_11 = "INSERT INTO `books`(title, author, description, status) VALUES('Arch of Triumph', 'Erich Maria Remarque', '1945_German', 'AVAILABLE')";

	@Test(priority = 0)
	public void test_afterInsert_notNull() {

		Assert.assertNotNull(controller.executeTask("SHOW_ALL_USERS"));
		Assert.assertNotNull(controller.executeTask("SHOW_ALL_BOOKS"));
	}

	@Test(priority = 3)
	public void test_insertDB_notNull() throws ServiceException {

		Assert.assertNotNull(clientImpl.showAllUsers());
		Assert.assertNotNull(libImpl.bookFondReviewService());
	}

	@Test(priority = 5, enabled = true)
	public void test_insertDB_size() throws ServiceException {

		Assert.assertEquals(clientImpl.showAllUsers().size(), 10);
		Assert.assertEquals(libImpl.bookFondReviewService().size(), 11);
	}

	@AfterClass
	public void afterClass() {

	}

	@BeforeMethod
	public void beforeMethod() {
		
		users = new ShowAllUsers();
		books = new ShowAllBooks();
		controller = Controller.getInstance();
		controller.executeTask("SIGN_IN marina1991 encryptT@1991");
		clientImpl = new ClientServiceImpl();
		libImpl = new LibraryServiceImpl();		
	}

	@BeforeClass
	public void beforeClass() {

		List<String> insertList = new ArrayList<>();

		insertList.add(USERS_INSERT_01);
		insertList.add(USERS_INSERT_02);
		insertList.add(USERS_INSERT_03);
		insertList.add(USERS_INSERT_04);
		insertList.add(USERS_INSERT_05);
		insertList.add(USERS_INSERT_06);
		insertList.add(USERS_INSERT_07);
		insertList.add(USERS_INSERT_08);
		insertList.add(USERS_INSERT_09);
		insertList.add(USERS_INSERT_10);		
		
		insertList.add(BOOKS_INSERT_01);
		insertList.add(BOOKS_INSERT_02);
		insertList.add(BOOKS_INSERT_03);
		insertList.add(BOOKS_INSERT_04);
		insertList.add(BOOKS_INSERT_05);
		insertList.add(BOOKS_INSERT_06);
		insertList.add(BOOKS_INSERT_07);
		insertList.add(BOOKS_INSERT_08);
		insertList.add(BOOKS_INSERT_09);
		insertList.add(BOOKS_INSERT_10);
		insertList.add(BOOKS_INSERT_11);

		try {
			connection = ConnectionManager.getManager().getConnection();
			connection.setAutoCommit(false);			

			for (String insert : insertList) {

				preparedStatement = connection.prepareStatement(insert);				
				preparedStatement.execute();
				preparedStatement.close();

				System.out.println("Record is inserted into DBUSER table!");
			}
			connection.commit();
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
