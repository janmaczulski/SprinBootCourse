package com.example.rest_crud_api.demo.entity;

import javax.persistence.Entity;

@Entity
public class Student {
	private Integer id;
	private String firstName;
	private String lastName;

	public Student(String firstName, String lastName, Integer id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
