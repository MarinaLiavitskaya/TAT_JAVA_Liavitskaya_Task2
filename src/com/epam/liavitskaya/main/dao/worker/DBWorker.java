package com.epam.liavitskaya.main.dao.worker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBWorker {

	private static String DB_URL;
	private static String DB_NAME;
	private static String DB_USER;
	private static String DB_PASSWORD;

	static Properties properties;
	static InputStream input = null;
	static Connection connection;

	public DBWorker(Properties properties) {
		DB_URL = properties.getProperty("url");
		DB_NAME = properties.getProperty("db_name");
		DB_USER = properties.getProperty("user");
		DB_PASSWORD = properties.getProperty("password");
	}
	
	public DBWorker(String dB_URL, String dB_NAME, String dB_USER, String dB_PASSWORD) {		
		DB_URL = dB_URL;
		DB_NAME = dB_NAME;
		DB_USER = dB_USER;
		DB_PASSWORD = dB_PASSWORD;
	}

	public void driverLoad() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	}

	public Connection getConnection() {
		connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

}