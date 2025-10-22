package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.artistEvent;
import com.back.control_event.model.artist;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IArtistEventRepository extends JpaRepository<artistEvent, Integer> {
    // Repositorio limpio, sin métodos personalizados

    @Query("select ae.artist from artistEvent ae where ae.event.id_event = :eventId")
    List<artist> findArtistsByEventId(@Param("eventId") int eventId);

    @Modifying
    @Query("delete from artistEvent ae where ae.event.id_event = :eventId")
    void deleteByEventId(@Param("eventId") int eventId);
}
