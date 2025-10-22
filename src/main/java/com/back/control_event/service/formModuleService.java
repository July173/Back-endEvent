package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.formModule;
import com.back.control_event.repository.IFormModuleRepository;

@Service
public class formModuleService {
    @Autowired
    private IFormModuleRepository formModuleRepository;

    public List<formModule> getAll() {
        return formModuleRepository.findAll();
    }

    public formModule getById(int id) {
        return formModuleRepository.findById(id).orElse(null);
    }

    public formModule save(formModule formModule) {
        return formModuleRepository.save(formModule);
    }

    public formModule update(formModule formModule) {
        return formModuleRepository.save(formModule);
    }
}
