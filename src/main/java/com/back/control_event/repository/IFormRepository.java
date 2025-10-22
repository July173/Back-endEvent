package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.form;

public interface IFormRepository extends JpaRepository<form, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
