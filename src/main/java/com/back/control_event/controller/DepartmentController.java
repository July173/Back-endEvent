
package com.back.control_event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.control_event.dto.responseDTO;
import com.back.control_event.model.department;
import com.back.control_event.service.departmentService;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/department/")
public class DepartmentController {

    @Autowired
    private departmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Object> registerDepartment(
           @RequestBody department department) {
            department.setStatus(1); // Activo por defecto
        responseDTO response = departmentService.save(department);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /*
     * GET: consultar
     * POST:crear registros
     * PUT: actualizar todo
     * DELETE: eliminar
     * PATCH: actualizar parcial
     */

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<department> list = departmentService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        department department = departmentService.getById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }





}
