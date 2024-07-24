package com.alpha.userDto;

public class User {
	private int UserId;
	private String userName;
	private String userEmail;
	private String passward;
	private String phoneNo;
	
	public int getUserId() {
		return UserId;
	}
	
	public User() {
		
	}
	public User(int userId, String userName, String userEmail, String passward, String phoneNo) {
		super();
		UserId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.passward = passward;
		this.phoneNo = phoneNo;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
