package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "user")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id_user;

	@Column(name = "email", nullable = false, length = 45, unique = true)
	private String email;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_person", nullable = false)
	private person person;

	@ManyToOne
	@JoinColumn(name = "id_role", nullable = false)
	private role role;

	public user() {}

	public user(String email, String password, person person, role role, int id_user) {
		this.email = email;
		this.password = password;
		this.person = person;
		this.role = role;
		this.id_user = id_user;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public person getPerson() {
		return person;
	}

	public void setPerson(person person) {
		this.person = person;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}
	
}


