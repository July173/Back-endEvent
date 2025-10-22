package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "municipio")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class municipio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20)
    private int id_municipio;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "code", nullable = false, length = 45)
    private String code;

    @Column(name = "status", nullable = false)
    private int status;

     @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    private department department;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    public municipio(String code, department department, String description, int id_municipio, String name, int status, Double latitude, Double longitude) {
        this.code = code;
        this.department = department;
        this.description = description;
        this.id_municipio = id_municipio;
        this.name = name;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
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

   

    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
        this.department = department;
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

    public municipio() {
    }
    
  
}
