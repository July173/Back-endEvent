package com.back.control_event.model;

import jakarta.persistence.*;

@Entity(name = "module")
public class module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_module")
	private int id_module;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "description", length = 45)
	private String description;

	public module() {}

	public module(String name, String description, int id_module) {
		this.name = name;
		this.description = description;
		this.id_module = id_module;
	}

	public int getId_module() {
		return id_module;
	}

	public void setId_module(int id_module) {
		this.id_module = id_module;
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

