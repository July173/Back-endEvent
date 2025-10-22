package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.module;
import com.back.control_event.service.moduleService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/module/")
public class ModuleController {
    @Autowired
    private moduleService moduleService;

    @PostMapping("/")
    public ResponseEntity<Object> registerModule(@RequestBody module module) {
        module result = moduleService.save(module);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<module> list = moduleService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        module module = moduleService.getById(id);
        return new ResponseEntity<>(module, HttpStatus.OK);
    }
}
