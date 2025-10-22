package com.back.control_event.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.control_event.model.event;

public interface IEventRepository extends JpaRepository<event, Integer> {
    @Query("SELECT e FROM event e WHERE e.municipio.id_municipio = :municipio")
    List<event> findByMunicipio(@Param("municipio") int municipio);

    @Query("SELECT e FROM event e WHERE e.municipio.department.id_department = :idDepartment")
    List<event> findByDepartment(@Param("idDepartment") int idDepartment);

    @Query("SELECT e FROM event e WHERE e.date_start >= :date_start AND e.date_end <= :date_end")
    List<event> findByDateRange(@Param("date_start") Date date_start, @Param("date_end") Date date_end);

    @Query("SELECT e FROM event e WHERE e.name LIKE %:filter% OR e.description LIKE %:filter%")
    List<event> search(@Param("filter") String filter);
}
