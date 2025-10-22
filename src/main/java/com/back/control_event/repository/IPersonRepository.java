package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.person;

public interface IPersonRepository extends JpaRepository<person, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
