package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.form;
import com.back.control_event.repository.IFormRepository;

@Service
public class formService {
    @Autowired
    private IFormRepository formRepository;

    public List<form> getAll() {
        return formRepository.findAll();
    }

    public form getById(int id) {
        return formRepository.findById(id).orElse(null);
    }

    public form save(form form) {
        return formRepository.save(form);
    }

    public form update(form form) {
        return formRepository.save(form);
    }
}
