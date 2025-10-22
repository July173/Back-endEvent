package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.genderMusic;
import com.back.control_event.service.genderMusicService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/gendermusic/")
public class GenderMusicController {
    @Autowired
    private genderMusicService genderMusicService;

    @PostMapping("/")
    public ResponseEntity<Object> registerGenderMusic(@RequestBody genderMusic genderMusic) {
        genderMusic.setStatus(1);
        genderMusic result = genderMusicService.save(genderMusic);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<genderMusic> list = genderMusicService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        genderMusic genderMusic = genderMusicService.getById(id);
        return new ResponseEntity<>(genderMusic, HttpStatus.OK);
    }
}
