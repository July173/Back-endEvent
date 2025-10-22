package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.paymentMethod;
import com.back.control_event.service.paymentMethodService;
import com.back.control_event.dto.responseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/payment-method/")
public class PaymentMethodController {
    @Autowired
    private paymentMethodService paymentMethodService;

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<paymentMethod> list = paymentMethodService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        paymentMethod pm = paymentMethodService.getById(id);
        return new ResponseEntity<>(pm, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody paymentMethod pm) {
        try {
            paymentMethodService.save(pm);
            responseDTO resp = new responseDTO("ok", "paymentMethod creado con éxito");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al crear paymentMethod");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
