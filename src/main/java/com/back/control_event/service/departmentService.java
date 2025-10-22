package com.back.control_event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.control_event.dto.responseDTO;
import com.back.control_event.model.department;
import com.back.control_event.repository.IDepartmentRepository;

@Service
public class departmentService {
    // se realiza la conexion con el repositorio
    @Autowired
    private IDepartmentRepository IDepartmentRepository;

    public List<department> getAll() {
        return IDepartmentRepository.findAllActive();
    }


    public department getById(int id) {
        return IDepartmentRepository.findById(id).get();
    }

    public responseDTO save(department department) {
        // Validar que el título no sea vacío
        if (department.getName() == null || department.getName().trim().isEmpty()) {
            return new responseDTO(
                    "Error",
                    "El name no puede estar vacío");
        }



        // Validar que la descripción no sea vacía
        if (department.getDescription() == null || department.getDescription().trim().isEmpty()) {
            return new responseDTO(
                    "Error",
                    "La descripción no puede estar vacía");
        }

      

        // Si todas las validaciones pasan, guardar el departamento
        IDepartmentRepository.save(department);
        return new responseDTO(
                "OK",
                "Se registró correctamente");
    }


    public responseDTO update(department department) {
        IDepartmentRepository.save(department);
        responseDTO response = new responseDTO(
                "OK",
                "Se actualizó correctamente");
        return response;
    }



}
