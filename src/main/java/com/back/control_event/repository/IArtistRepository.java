package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.artist;

public interface IArtistRepository extends JpaRepository<artist, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
