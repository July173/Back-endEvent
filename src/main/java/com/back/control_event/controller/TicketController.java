package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.ticket;
import com.back.control_event.service.ticketService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/ticket/")
public class TicketController {
    @Autowired
    private ticketService ticketService;

    @PostMapping("/")
    public ResponseEntity<Object> registerTicket(@RequestBody ticket ticket) {
        ticket result = ticketService.save(ticket);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<ticket> list = ticketService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        ticket ticket = ticketService.getById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
