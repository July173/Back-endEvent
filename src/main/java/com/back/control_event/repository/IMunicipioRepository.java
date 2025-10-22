package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.municipio;

public interface IMunicipioRepository extends JpaRepository<municipio, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
