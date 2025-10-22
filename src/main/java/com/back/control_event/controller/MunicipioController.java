package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.municipio;
import com.back.control_event.service.municipioService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/municipio/")
public class MunicipioController {
    @Autowired
    private municipioService municipioService;

    @PostMapping("/")
    public ResponseEntity<Object> registerMunicipio(@RequestBody municipio municipio) {
        municipio.setStatus(1);
        municipio result = municipioService.save(municipio);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<municipio> list = municipioService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        municipio municipio = municipioService.getById(id);
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }
}
