package com.laptrinhweb.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {
	Long id;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	double salary;
	List<JobHistoryDTO> listJH = new ArrayList<JobHistoryDTO>();
	boolean active;
	

	public List<JobHistoryDTO> getListJH() {
		return listJH;
	}

	public void setListJH(List<JobHistoryDTO> listJH) {
		this.listJH = listJH;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
