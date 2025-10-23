package com.back.control_event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.control_event.dto.LoginDTO;
import com.back.control_event.dto.responseDTO;
import com.back.control_event.service.personService;
import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private personService personService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO dto) {
        Integer idUser = personService.authenticate(dto);
        if (idUser != null) {
            Map<String, Object> body = new HashMap<>();
            body.put("id_user", idUser);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(new responseDTO("error", "credenciales inválidas"), HttpStatus.UNAUTHORIZED);
    }
}
