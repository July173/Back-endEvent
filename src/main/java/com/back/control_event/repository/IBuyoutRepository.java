package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.buyout;

public interface IBuyoutRepository extends JpaRepository<buyout, Integer> {
}
