package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.role;
import com.back.control_event.service.roleService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/role/")
public class RoleController {
    @Autowired
    private roleService roleService;

    @PostMapping("/")
    public ResponseEntity<Object> registerRole(@RequestBody role role) {
        role result = roleService.save(role);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<role> list = roleService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        role role = roleService.getById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
