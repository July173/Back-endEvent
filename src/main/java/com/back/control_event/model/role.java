package com.back.control_event.model;

import jakarta.persistence.*;

@Entity(name = "role")
public class role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private int id_role;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	public role() {}

	public role(String name, String description, int id_role) {
		this.name = name;
		this.description = description;
		this.id_role = id_role;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

