package com.back.control_event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "payMethod")
public class paymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay_method")
    private int id_pay_method;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    public paymentMethod() {}

    public int getId_pay_method() {
        return id_pay_method;
    }

    public void setId_pay_method(int id_pay_method) {
        this.id_pay_method = id_pay_method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
