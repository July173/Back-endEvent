package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.person;
import com.back.control_event.service.personService;
import com.back.control_event.dto.RegisterDTO;
import com.back.control_event.model.user;
import com.back.control_event.dto.responseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/person/")
public class PersonController {
    @Autowired
    private personService personService;

    @PostMapping("/")
    public ResponseEntity<Object> registerPerson(@RequestBody RegisterDTO dto) {
        try {
            dto.setRoleId(2); // asignar rol CLIENT por defecto
            personService.registerUser(dto);
            responseDTO resp = new responseDTO("ok", "person creado con éxito");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al registrar");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
