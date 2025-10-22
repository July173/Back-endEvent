package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.person;
import com.back.control_event.service.personService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/person/")
public class PersonController {
    @Autowired
    private personService personService;

    @PostMapping("/")
    public ResponseEntity<Object> registerPerson(@RequestBody person person) {
        person result = personService.save(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<person> list = personService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        person person = personService.getById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
