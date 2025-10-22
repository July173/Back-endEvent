package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.back.control_event.model.formModule;

public interface IFormModuleRepository extends JpaRepository<formModule, Integer> {
    @Query("select fm from formModule fm where fm.form.id_form = :formId")
    formModule findByFormId(@Param("formId") int formId);
}
