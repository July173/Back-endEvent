package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.locatedEvent;
import com.back.control_event.service.locatedEventService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/locatedevent/")
public class LocatedEventController {
    @Autowired
    private locatedEventService locatedEventService;

    @PostMapping("/")
    public ResponseEntity<Object> registerLocatedEvent(@RequestBody locatedEvent locatedEvent) {
        locatedEvent.setStatus(1);
        locatedEvent result = locatedEventService.save(locatedEvent);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<locatedEvent> list = locatedEventService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        locatedEvent locatedEvent = locatedEventService.getById(id);
        return new ResponseEntity<>(locatedEvent, HttpStatus.OK);
    }
}
