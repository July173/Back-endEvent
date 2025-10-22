package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.module;
import com.back.control_event.repository.IModuleRepository;

@Service
public class moduleService {
    @Autowired
    private IModuleRepository moduleRepository;

    public List<module> getAll() {
        return moduleRepository.findAll();
    }

    public module getById(int id) {
        return moduleRepository.findById(id).orElse(null);
    }

    public module save(module module) {
        return moduleRepository.save(module);
    }

    public module update(module module) {
        return moduleRepository.save(module);
    }
}
