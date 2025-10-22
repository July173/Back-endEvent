package com.back.control_event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.control_event.model.locatedEvent;
import com.back.control_event.service.locatedEventService;
import com.back.control_event.dto.responseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/locatedevent/")
public class LocatedEventController {
    @Autowired
    private locatedEventService locatedEventService;

    @PostMapping("/")
    public ResponseEntity<Object> registerLocatedEvent(@RequestBody locatedEvent locatedEvent) {
        try {
            locatedEvent.setStatus(1);
            locatedEventService.save(locatedEvent);
            responseDTO resp = new responseDTO("ok", "locatedEvent creado con éxito");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al crear locatedEvent");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody locatedEvent le) {
        le.setId_located_event(id);
        locatedEvent updated = locatedEventService.update(le);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        locatedEventService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
