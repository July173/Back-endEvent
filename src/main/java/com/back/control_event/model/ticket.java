package com.back.control_event.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name = "ticket")
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", length = 20)
    private int id_ticket;

    @Column(name = "value", nullable = false)
    private java.math.BigDecimal value;

    @Column(name = "count", nullable = false)
    private int count;

    @ManyToOne
    @JoinColumn(name = "id_event", nullable = false)
    private event event;

    @ManyToOne
    @JoinColumn(name = "id_located_event", nullable = false)
    private locatedEvent locatedEvent;
   
    public ticket() {}

    public ticket(int id_ticket,  java.math.BigDecimal value, int count, event event, locatedEvent locatedEvent) {
        this.id_ticket = id_ticket;
        this.value = value;
        this.count = count;
        this.event = event;
        this.locatedEvent = locatedEvent;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public java.math.BigDecimal getValue() {
        return value;
    }

    public void setValue(java.math.BigDecimal value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public event getEvent() {
        return event;
    }

    public void setEvent(event event) {
        this.event = event;
    }

    public locatedEvent getLocatedEvent() {
        return locatedEvent;
    }

    public void setLocatedEvent(locatedEvent locatedEvent) {
        this.locatedEvent = locatedEvent;
    }


   
}
