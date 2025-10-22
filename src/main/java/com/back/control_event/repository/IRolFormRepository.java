package com.back.control_event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.control_event.model.rolForm;

public interface IRolFormRepository extends JpaRepository<rolForm, Integer> {

    @Query("SELECT rf FROM rolForm rf WHERE rf.role.id_role = :roleId")
    List<rolForm> findByRoleId(@Param("roleId") int roleId);
}
