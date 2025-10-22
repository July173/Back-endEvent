package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.artistEvent;
import com.back.control_event.model.artist;
import java.util.List;
import java.util.Date;
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

    // Verifica si un artista ya está asignado a otro evento que se solapa con el rango dado
    @Query("select (count(ae) > 0) from artistEvent ae "
         + "where ae.artist.id = :artistId "
         + "and (:start < ae.event.date_end and :end > ae.event.date_start)")
    boolean existsArtistScheduleConflict(@Param("artistId") int artistId,
                                         @Param("start") Date start,
                                         @Param("end") Date end);

    // Igual que el anterior, pero excluyendo un evento específico (para updates)
    @Query("select (count(ae) > 0) from artistEvent ae "
         + "where ae.artist.id = :artistId "
         + "and ae.event.id_event <> :eventId "
         + "and (:start < ae.event.date_end and :end > ae.event.date_start)")
    boolean existsArtistScheduleConflictExcludingEvent(@Param("artistId") int artistId,
                                                       @Param("start") Date start,
                                                       @Param("end") Date end,
                                                       @Param("eventId") int eventId);
}
