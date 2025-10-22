package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "form")
public class form {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_form")
	private int id_form;

	@Column(name = "name", nullable = false, length = 60)
	private String name;

	@Column(name = "description", nullable = false, length = 80)
	private String description;

	@Column(name = "path", nullable = false, length = 45)
	private String path;

	public form() {}

	public form(String name, String description, String path, int id_form) {
		this.name = name;
		this.description = description;
		this.path = path;
		this.id_form = id_form;
	}

	public int getId_form() {
		return id_form;
	}

	public void setId_form(int id_form) {
		this.id_form = id_form;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

    public module getModule() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


