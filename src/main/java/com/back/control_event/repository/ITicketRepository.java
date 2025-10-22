package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.ticket;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITicketRepository extends JpaRepository<ticket, Integer> {
    // Repositorio limpio, sin métodos personalizados

    @Query("select t from ticket t where t.event.id_event = :eventId")
    List<ticket> findByEventId(@Param("eventId") int eventId);

    @Modifying
    @Query("delete from ticket t where t.event.id_event = :eventId")
    void deleteByEventId(@Param("eventId") int eventId);
}
