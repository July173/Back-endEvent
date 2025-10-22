package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "formModule")
public class formModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_form_module")
	private int id_form_module;

	@ManyToOne
	@JoinColumn(name = "id_form", nullable = false)
	private form form;

	@ManyToOne
	@JoinColumn(name = "id_module", nullable = false)
	private module module;

	public formModule() {}

	public formModule(form form, module module, int id_form_module) {
		this.form = form;
		this.module = module;
		this.id_form_module = id_form_module;
	}

	public int getId_form_module() {
		return id_form_module;
	}

	public void setId_form_module(int id_form_module) {
		this.id_form_module = id_form_module;
	}

	public form getForm() {
		return form;
	}

	public void setForm(form form) {
		this.form = form;
	}

	public module getModule() {
		return module;
	}

	public void setModule(module module) {
		this.module = module;
	}
	
}

