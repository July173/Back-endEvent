package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.user;
import com.back.control_event.service.userService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/user/")
public class UserController {
    @Autowired
    private userService userService;

    @PostMapping("/")
    public ResponseEntity<Object> registerUser(@RequestBody user user) {
        user result = userService.save(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<user> list = userService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        user user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
