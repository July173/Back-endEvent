package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.back.control_event.model.person;

public interface IPersonRepository extends JpaRepository<person, Integer> {
    @Query("select (count(p) > 0) from person p where p.number_identification = :doc")
    boolean existsByDocument(@Param("doc") long numberIdentification);
}
