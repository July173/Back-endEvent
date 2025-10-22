package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "department")
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20)
    private int id_department;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "code", nullable = false, length = 45)
    private String code;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
      public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public department(int id_department, String name, String description, String code, int status, Double latitude, Double longitude) {
        this.id_department = id_department;
        this.name = name;
        this.description = description;
        this.code = code;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

  
 public department() {
    }




}
