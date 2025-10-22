package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.role;

public interface IRoleRepository extends JpaRepository<role, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
