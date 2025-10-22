package com.back.control_event.model;

import jakarta.persistence.*;

@Entity(name = "rolForm")
public class rolForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol_form")
	private int id_rol_form;

	@ManyToOne
	@JoinColumn(name = "id_role", nullable = false)
	private role role;

	@ManyToOne
	@JoinColumn(name = "id_form", nullable = false)
	private form form;

	public rolForm() {}

	public rolForm(role role, form form, int id_rol_form) {
		this.role = role;
		this.form = form;
		this.id_rol_form = id_rol_form;
	}

	public int getId_rol_form() {
		return id_rol_form;
	}

	public void setId_rol_form(int id_rol_form) {
		this.id_rol_form = id_rol_form;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}

	public form getForm() {
		return form;
	}

	public void setForm(form form) {
		this.form = form;
	}
}


