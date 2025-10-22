package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.control_event.model.paymentMethod;

public interface IPaymentMethodRepository extends JpaRepository<paymentMethod, Integer> {
}
