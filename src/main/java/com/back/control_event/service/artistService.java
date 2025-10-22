package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.artist;
import com.back.control_event.repository.IArtistRepository;

@Service
public class artistService {
    @Autowired
    private IArtistRepository artistRepository;

    public List<artist> getAll() {
        return artistRepository.findAll();
    }

    public artist getById(int id) {
        return artistRepository.findById(id).orElse(null);
    }

    public artist save(artist artist) {
        return artistRepository.save(artist);
    }

    public artist update(artist artist) {
        return artistRepository.save(artist);
    }

    public void setArtistStatus(int id, int status) {
        artist a = artistRepository.findById(id).orElse(null);
        if (a != null) {
            a.setStatus(status);
            artistRepository.save(a);
        }
    }
}
