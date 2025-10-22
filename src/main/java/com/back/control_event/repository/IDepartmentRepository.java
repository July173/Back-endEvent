package com.back.control_event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.back.control_event.model.department;

public interface IDepartmentRepository extends JpaRepository<department, Integer> {
@CrossOrigin(origins = "http://localhost:5173")

     @Query("SELECT d FROM department d WHERE d.status=1")
    List<department> findAllActive();


}
