package com.epam.liavitskaya.main.bean;

import java.util.Map;

import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.enums.UserStatus;

public class User {

	private int userId;
	private String userName;
	private UserRoles userRole;
	private String login;
	private String password;
	private UserStatus userStatus;
	private Map<Integer, Integer> libraryCard;	

	public User() {		
	}	
	
	public User(String userName, String login, String password) {		
		this.userName = userName;
		this.login = login;
		this.password = password;
	}

	public User(int userId, String userName, UserRoles userRole, String login, String password, UserStatus userStatus,
			Map<Integer, Integer> libraryCard) {		
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.login = login;
		this.password = password;
		this.userStatus = userStatus;
		this.libraryCard = libraryCard;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole.name();
	}

	public void setUserRole(String userRole) {
		this.userRole = UserRoles.valueOf(userRole);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserStatus() {
		return userStatus.name();
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = UserStatus.valueOf(userStatus);
	}

	public Map<Integer, Integer> getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(Map<Integer, Integer> libraryCard) {
		this.libraryCard = libraryCard;
	}

}
