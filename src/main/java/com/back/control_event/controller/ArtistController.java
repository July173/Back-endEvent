package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.artist;
import com.back.control_event.service.artistService;
import com.back.control_event.dto.responseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/artist/")
public class ArtistController {
    @Autowired
    private artistService artistService;

    @PostMapping("/")
    public ResponseEntity<Object> registerArtist(@RequestBody artist artist) {
        try {
            artist.setStatus(1);
            artistService.save(artist);
            responseDTO resp = new responseDTO("ok", "artist creado con éxito");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al crear artist");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArtist(@PathVariable int id, @RequestBody artist artist) {
        artist.setId_artist(id);
        artist updated = artistService.update(artist);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Object> setArtistStatus(@PathVariable int id, @RequestParam int status) {
        artistService.setArtistStatus(id, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
