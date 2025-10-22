package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.locatedEvent;
import com.back.control_event.repository.ILocatedEventRepository;

@Service
public class locatedEventService {
    @Autowired
    private ILocatedEventRepository locatedEventRepository;

    public List<locatedEvent> getAll() {
        return locatedEventRepository.findAll();
    }

    public locatedEvent getById(int id) {
        return locatedEventRepository.findById(id).orElse(null);
    }

    public locatedEvent save(locatedEvent locatedEvent) {
        return locatedEventRepository.save(locatedEvent);
    }

    public locatedEvent update(locatedEvent locatedEvent) {
        return locatedEventRepository.save(locatedEvent);
    }

    public void deleteById(int id) {
        locatedEventRepository.deleteById(id);
    }
}
