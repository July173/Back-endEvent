package com.back.control_event.model;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "event")
public class event {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20)
    private int id_event;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "code", nullable = false, length = 45)
    private int code;

    @Column(name = "status", nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = false)
    private municipio municipio;
    
    @Column(name = "schedule", nullable = false, length = 100)
    private String schedule;

    @Column(name = "dateStart", nullable = false)
    private Date date_start;

    @Column(name = "dateEnd", nullable = false)
    private Date date_end;

    public event(int code, Date date_end, Date date_start, String description, int id_event, municipio municipio, String name, String schedule, int status) {
        this.code = code;
        this.date_end = date_end;
        this.date_start = date_start;
        this.description = description;
        this.id_event = id_event;
        this.municipio = municipio;
        this.name = name;
        this.schedule = schedule;
        this.status = status;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ticket> tickets;

    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<artistEvent> artistEvents;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(municipio municipio) {
        this.municipio = municipio;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }


    public event() {}

    public List<ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<ticket> tickets) {
        this.tickets = tickets;
    }

    public List<artistEvent> getArtistEvents() {
        return artistEvents;
    }

    public void setArtistEvents(List<artistEvent> artistEvents) {
        this.artistEvents = artistEvents;
    }
}
