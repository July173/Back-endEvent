package com.back.control_event.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.control_event.dto.EventCreateDTO;
import com.back.control_event.dto.EventDetailDTO;
import com.back.control_event.dto.responseDTO;
import com.back.control_event.model.event;
import com.back.control_event.service.eventService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/event/")
public class EventController {
    @Autowired
    private eventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestBody EventCreateDTO dto) {
        try {
            event created = eventService.createEvent(dto);
            EventDetailDTO detail = eventService.getEventDetail(created.getId_event());
            return new ResponseEntity<>(detail, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al crear el evento");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getEvents(
        @RequestParam(required = false) Integer municipioId,
        @RequestParam(required = false) Integer departmentId,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
        @RequestParam(required = false) String filter
    ) {
        List<event> events = eventService.getEventsByFilters(municipioId, departmentId, startDate, endDate, filter);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        event event = eventService.getById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<Object> findDetailById(@PathVariable int id) {
        EventDetailDTO detail = eventService.getEventDetail(id);
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable int id, @RequestBody EventCreateDTO dto) {
        try {
            event result = eventService.updateEvent(dto, id);
            if (result == null) {
                responseDTO resp = new responseDTO("error", "event no encontrado: id=" + id);
                return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
            }
            EventDetailDTO detail = eventService.getEventDetail(result.getId_event());
            return new ResponseEntity<>(detail, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            responseDTO resp = new responseDTO("error", ex.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            responseDTO resp = new responseDTO("error", "Error interno al actualizar el evento");
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Object> setEventStatus(@PathVariable int id, @RequestParam int status) {
        eventService.setEventStatus(id, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
