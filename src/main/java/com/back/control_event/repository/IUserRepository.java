package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.user;

public interface IUserRepository extends JpaRepository<user, Integer> {
    user findByEmail(String email);
}
