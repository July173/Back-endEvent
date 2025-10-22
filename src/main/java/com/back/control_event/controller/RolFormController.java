package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.rolForm;
import com.back.control_event.service.rolFormService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/rolform/")
public class RolFormController {
    @Autowired
    private rolFormService rolFormService;

    @PostMapping("/")
    public ResponseEntity<Object> registerRolForm(@RequestBody rolForm rolForm) {
        rolForm result = rolFormService.save(rolForm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<rolForm> list = rolFormService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        rolForm rolForm = rolFormService.getById(id);
        return new ResponseEntity<>(rolForm, HttpStatus.OK);
    }
}
