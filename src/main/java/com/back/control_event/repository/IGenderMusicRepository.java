package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.genderMusic;

public interface IGenderMusicRepository extends JpaRepository<genderMusic, Integer> {
    // Repositorio limpio, sin métodos personalizados
}
