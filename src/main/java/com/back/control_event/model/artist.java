package com.back.control_event.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name = "artist")
public class artist {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20)
    private int id_artist;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "lastName", nullable = false, length = 100)
    private String last_name;
    
    @Column(name = "origenCity", nullable = false, length = 100)
    private String origen_city;


    @Column(name = "code", nullable = false, length = 45)
    private String code;

    @Column(name = "status", nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "id_genderMusic", nullable = false)
    private genderMusic genderMusic;

    public artist(String code, genderMusic genderMusic, int id_artist, String last_name, String name, String origen_city, int status) {
        this.code = code;
        this.genderMusic = genderMusic;
        this.id_artist = id_artist;
        this.last_name = last_name;
        this.name = name;
        this.origen_city = origen_city;
        this.status = status;
    }

    public int getId_artist() {
        return id_artist;
    }

    public void setId_artist(int id_artist) {
        this.id_artist = id_artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getOrigen_city() {
        return origen_city;
    }

    public void setOrigen_city(String origen_city) {
        this.origen_city = origen_city;
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

    public genderMusic getGenderMusic() {
        return genderMusic;
    }

    public void setGenderMusic(genderMusic genderMusic) {
        this.genderMusic = genderMusic;
    }


    
    public artist() {
    }

}
