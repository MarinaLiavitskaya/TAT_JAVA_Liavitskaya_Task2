package com.epam.liavitskaya.main.bean;

import com.epam.liavitskaya.main.enums.UserRoles;
import com.epam.liavitskaya.main.enums.UserStatus;

public class User {

	private int userId;
	private String userName;
	private String passportNo;
	private String phone;
	private String email;
	private UserRoles userRole;
	private String login;
	private String password;
	private UserStatus userStatus;

	public User() {
	}

	public User(String userName, String login, String password) {
		this.userName = userName;
		this.login = login;
		this.password = password;
	}
	
	public User(String userName, UserRoles userRole, String login, String password, UserStatus userStatus) {
		this.userName = userName;
		this.userRole = userRole;
		this.login = login;
		this.password = password;
		this.userStatus = userStatus;
	}	
	
	public User(String userName, String passportNo, String phone, String email, UserRoles userRole, String login,
			String password, UserStatus userStatus) {		
		this.userName = userName;
		this.passportNo = passportNo;
		this.phone = phone;
		this.email = email;
		this.userRole = userRole;
		this.login = login;
		this.password = password;
		this.userStatus = userStatus;
	}

	public User(int userId, String userName, String passportNo, String phone, String email, UserRoles userRole,
			String login, String password, UserStatus userStatus) {		
		this.userId = userId;
		this.userName = userName;
		this.passportNo = passportNo;
		this.phone = phone;
		this.email = email;
		this.userRole = userRole;
		this.login = login;
		this.password = password;
		this.userStatus = userStatus;
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

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassportNo=" + passportNo + ", phone=" + phone + ", email="
				+ email + ", userRole=" + userRole + ", login=" + login + ", userStatus=" + userStatus + "]";
	}	
	
}
