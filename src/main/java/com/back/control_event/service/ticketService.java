package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.ticket;
import com.back.control_event.repository.ITicketRepository;

@Service
public class ticketService {
    @Autowired
    private ITicketRepository ticketRepository;

    public List<ticket> getAll() {
        return ticketRepository.findAll();
    }

    public ticket getById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public ticket save(ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public ticket update(ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
