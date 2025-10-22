package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.genderMusic;
import com.back.control_event.repository.IGenderMusicRepository;

@Service
public class genderMusicService {
    @Autowired
    private IGenderMusicRepository genderMusicRepository;

    public List<genderMusic> getAll() {
        return genderMusicRepository.findAll();
    }

    public genderMusic getById(int id) {
        return genderMusicRepository.findById(id).orElse(null);
    }

    public genderMusic save(genderMusic genderMusic) {
        return genderMusicRepository.save(genderMusic);
    }

    public genderMusic update(genderMusic genderMusic) {
        return genderMusicRepository.save(genderMusic);
    }
}
