package com.back.control_event.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "gender_music")
public class genderMusic {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20)
    private int id_gender_music;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;


    @Column(name = "status", nullable = false)
    private int status;
    
    public int getId_genderMusic() {
        return id_gender_music;
    }

    public void setId_genderMusic(int id_gender_music) {
        this.id_gender_music = id_gender_music;
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

      public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public genderMusic(int id_gender_music, String name, String description,  int status) {
        this.id_gender_music = id_gender_music;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public genderMusic() {}
}
