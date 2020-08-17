package com.laptrinhweb.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;
//
//	@ManyToMany(mappedBy = "roles")
//	private Set<UserEntity> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public Set<UserEntity> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<UserEntity> users) {
//		this.users = users;
//	}

}
