package com.back.control_event.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.rolForm;
import com.back.control_event.model.form;
import com.back.control_event.model.module;
import com.back.control_event.repository.IRolFormRepository;
import com.back.control_event.dto.MenuDTO;
import com.back.control_event.dto.FormDTO;

@Service
public class rolFormService {
    @Autowired
    private IRolFormRepository rolFormRepository;

    public List<rolForm> getAll() {
        return rolFormRepository.findAll();
    }

    public rolForm getById(int id) {
        return rolFormRepository.findById(id).orElse(null);
    }

    public rolForm save(rolForm rolForm) {
        return rolFormRepository.save(rolForm);
    }

    public rolForm update(rolForm rolForm) {
        return rolFormRepository.save(rolForm);
    }

    public List<MenuDTO> getMenuByRole(int roleId) {
        List<rolForm> rolForms = rolFormRepository.findByRoleId(roleId);
        Map<module, List<form>> moduleFormsMap = new HashMap<>();

        for (rolForm rf : rolForms) {
            form f = rf.getForm();
            module m = f.getModule(); 
            moduleFormsMap.computeIfAbsent(m, k -> new ArrayList<>()).add(f);
        }

        List<MenuDTO> menu = new ArrayList<>();
        for (Map.Entry<module, List<form>> entry : moduleFormsMap.entrySet()) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setModuleName(entry.getKey().getName());
            List<FormDTO> formDTOs = new ArrayList<>();
            for (form f : entry.getValue()) {
                FormDTO fdto = new FormDTO();
                fdto.setFormName(f.getName());
                fdto.setPath(f.getPath());
                formDTOs.add(fdto);
            }
            menuDTO.setForms(formDTOs);
            menu.add(menuDTO);
        }
        return menu;
    }
}
