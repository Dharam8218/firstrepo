package com.alrs.models;

public class Model {
	
	private String name;
	private String userId;
	private String email;
	private long phone;
	private String password;
	private String userType;
	private String DOB;
	public String getName() {
		return name;
	}
	public String getUserId() {
		return userId;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public String getUserType() {
		return userType;
	}
	public String getDOB() {
		return DOB;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
}
