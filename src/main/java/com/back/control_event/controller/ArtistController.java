package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.artist;
import com.back.control_event.service.artistService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/artist/")
public class ArtistController {
    @Autowired
    private artistService artistService;

    @PostMapping("/")
    public ResponseEntity<Object> registerArtist(@RequestBody artist artist) {
        artist.setStatus(1);
        artist result = artistService.save(artist);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<artist> list = artistService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        artist artist = artistService.getById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }
}
