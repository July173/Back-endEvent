package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.locatedEvent;

public interface ILocatedEventRepository extends JpaRepository<locatedEvent, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
