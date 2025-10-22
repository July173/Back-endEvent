package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.formModule;

public interface IFormModuleRepository extends JpaRepository<formModule, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
