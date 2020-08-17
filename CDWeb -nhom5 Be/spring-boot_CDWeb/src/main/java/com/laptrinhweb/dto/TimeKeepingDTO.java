package com.laptrinhweb.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.laptrinhweb.entity.EmployeeEntity;

public class TimeKeepingDTO {
	private Long id;

	private int workTime;

	private int minimumTime;

	private int timeLate;

	private int overTime;

	private int note;

	private String dateStart;

	private String dateEnd;

	private Long employeeId;

	private int satus;

	public int getSatus() {
		return satus;
	}

	public void setSatus(int satus) {
		this.satus = satus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public int getMinimumTime() {
		return minimumTime;
	}

	public void setMinimumTime(int minimumTime) {
		this.minimumTime = minimumTime;
	}

	public int getTimeLate() {
		return timeLate;
	}

	public void setTimeLate(int timeLate) {
		this.timeLate = timeLate;
	}

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}