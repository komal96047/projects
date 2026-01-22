package com.studentManagementSystem.entity;

import java.lang.annotation.Inherited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	
	@Column(name ="first_name")
	private String firstname;
	
	@Column(name ="last_name")
	private String lastname;
	
	private String email;
	
	public Student()
	{
		super();
	}
	
	public Student(int id , String firstname ,String lastname ,String email)
	{
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
