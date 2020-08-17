package com.laptrinhweb.dto;

public class FormLogin {
	private String user;
	private String pass;
	public FormLogin(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public FormLogin() {
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	

}
