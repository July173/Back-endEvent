package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.buyout;
import com.back.control_event.service.buyoutService;
import com.back.control_event.dto.responseDTO;
import com.back.control_event.dto.BuyoutHistoryDTO;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getHistory(
        @PathVariable int userId,
        @RequestParam(required = false) String event,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) {
        List<BuyoutHistoryDTO> history = buyoutService.getHistoryByUser(userId, event, startDate, endDate);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}
