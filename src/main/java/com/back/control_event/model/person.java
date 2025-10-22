package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "person")
public class person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private int id_person;

	@Column(name = "full_name", nullable = false, length = 118)
	private String full_name;

	@Column(name = "number_identification", nullable = false)
	private long number_identification;

	@Column(name = "type_identification", nullable = false)
	private String type_identification;

	public person() {}

    public person(String full_name, int id_person, long number_identification, String type_identification) {
        this.full_name = full_name;
        this.id_person = id_person;
        this.number_identification = number_identification;
        this.type_identification = type_identification;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public long getNumber_identification() {
        return number_identification;
    }

    public void setNumber_identification(long number_identification) {
        this.number_identification = number_identification;
    }

    public String getType_identification() {
        return type_identification;
    }

    public void setType_identification(String type_identification) {
        this.type_identification = type_identification;
    }

	
}

