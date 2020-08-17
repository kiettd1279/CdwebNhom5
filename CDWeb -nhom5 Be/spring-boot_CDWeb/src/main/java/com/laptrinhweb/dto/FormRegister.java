package com.laptrinhweb.dto;

public class FormRegister {
	private String user;
	private String pass;
	private String email;
	public FormRegister(String user, String pass, String email) {
		super();
		this.user = user;
		this.pass = pass;
		this.email = email;
	}
	public FormRegister() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
