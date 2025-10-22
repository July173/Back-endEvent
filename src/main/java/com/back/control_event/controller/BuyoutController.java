package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.buyout;
import com.back.control_event.service.buyoutService;
import com.back.control_event.dto.responseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/buyout/")
public class BuyoutController {
    @Autowired
    private buyoutService buyoutService;

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<buyout> list = buyoutService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        buyout b = buyoutService.getById(id);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody buyout b) {
        try {
            buyoutService.create(b);
            responseDTO resp = new responseDTO("ok", "compra registrada con éxito");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al crear buyout");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
