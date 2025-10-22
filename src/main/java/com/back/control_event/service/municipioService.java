package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.municipio;
import com.back.control_event.repository.IMunicipioRepository;

@Service
public class municipioService {
    @Autowired
    private IMunicipioRepository municipioRepository;

    public List<municipio> getAll() {
        return municipioRepository.findAll();
    }

    public municipio getById(int id) {
        return municipioRepository.findById(id).orElse(null);
    }

    public municipio save(municipio municipio) {
        if (municipio.getLatitude() == null) {
            throw new IllegalArgumentException("latitude es obligatoria");
        }
        if (municipio.getLongitude() == null) {
            throw new IllegalArgumentException("longitude es obligatoria");
        }
        return municipioRepository.save(municipio);
    }

    public municipio update(municipio municipio) {
        return municipioRepository.save(municipio);
    }
}
