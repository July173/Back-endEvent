package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.user;
import com.back.control_event.service.userService;
import com.back.control_event.dto.responseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/user/")
public class UserController {
    @Autowired
    private userService userService;

    @PostMapping("/")
    public ResponseEntity<Object> registerUser(@RequestBody user user) {
        try {
            userService.save(user);
            responseDTO resp = new responseDTO("ok", "user creado con éxito");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al crear user");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody user payload) {
        user updated = userService.updateUserWithPerson(id, payload);
        if (updated == null) {
            responseDTO resp = new responseDTO("error", "user no encontrado: id=" + id);
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchUser(@PathVariable int id, @RequestBody user payload) {
        user updated = userService.updateUserWithPerson(id, payload);
        if (updated == null) {
            responseDTO resp = new responseDTO("error", "user no encontrado: id=" + id);
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
