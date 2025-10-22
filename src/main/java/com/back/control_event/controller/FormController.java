package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.form;
import com.back.control_event.service.formService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/form/")
public class FormController {
    @Autowired
    private formService formService;

    @PostMapping("/")
    public ResponseEntity<Object> registerForm(@RequestBody form form) {
        form result = formService.save(form);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<form> list = formService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        form form = formService.getById(id);
        return new ResponseEntity<>(form, HttpStatus.OK);
    }
}
