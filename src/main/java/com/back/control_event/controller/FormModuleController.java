package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.formModule;
import com.back.control_event.service.formModuleService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/formmodule/")
public class FormModuleController {
    @Autowired
    private formModuleService formModuleService;

    @PostMapping("/")
    public ResponseEntity<Object> registerFormModule(@RequestBody formModule formModule) {
        formModule result = formModuleService.save(formModule);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<formModule> list = formModuleService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        formModule formModule = formModuleService.getById(id);
        return new ResponseEntity<>(formModule, HttpStatus.OK);
    }
}
