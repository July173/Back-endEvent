package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.role;
import com.back.control_event.repository.IRoleRepository;

@Service
public class roleService {
    @Autowired
    private IRoleRepository roleRepository;

    public List<role> getAll() {
        return roleRepository.findAll();
    }

    public role getById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    public role save(role role) {
        return roleRepository.save(role);
    }

    public role update(role role) {
        return roleRepository.save(role);
    }
}
