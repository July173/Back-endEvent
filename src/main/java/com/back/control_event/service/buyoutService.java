package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.buyout;
import com.back.control_event.repository.IBuyoutRepository;

@Service
public class buyoutService {
    @Autowired
    private IBuyoutRepository buyoutRepository;

    public List<buyout> getAll() { return buyoutRepository.findAll(); }
    public buyout getById(int id) { return buyoutRepository.findById(id).orElse(null); }
    public buyout save(buyout b) { return buyoutRepository.save(b); }
    public buyout update(buyout b) { return buyoutRepository.save(b); }
}
