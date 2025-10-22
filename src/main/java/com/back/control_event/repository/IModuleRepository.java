package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.module;

public interface IModuleRepository extends JpaRepository<module, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
