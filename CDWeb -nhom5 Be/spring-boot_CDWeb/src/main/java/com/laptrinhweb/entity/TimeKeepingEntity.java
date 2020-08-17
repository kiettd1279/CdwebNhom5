package com.laptrinhweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timeKeeping")
public class TimeKeepingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int workTime ;
	
	@Column
	private int minimumTime ;
	
	@Column
	private int timeLate;
	
	@Column
	private int overTime ;
	
	@Column
	private int note ;
	
	@Column
	private String dateStart;
	
	@Column
	private String dateEnd ;
	
	@Column
	private int status ;
	
	@ManyToOne
	@JoinColumn(name = "timeKeeping_id")
	private EmployeeEntity employee;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
}
