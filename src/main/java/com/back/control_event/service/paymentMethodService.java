package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.paymentMethod;
import com.back.control_event.repository.IPaymentMethodRepository;

@Service
public class paymentMethodService {
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;

    public List<paymentMethod> getAll() { return paymentMethodRepository.findAll(); }
    public paymentMethod getById(int id) { return paymentMethodRepository.findById(id).orElse(null); }
    public paymentMethod save(paymentMethod pm) { return paymentMethodRepository.save(pm); }
    public paymentMethod update(paymentMethod pm) { return paymentMethodRepository.save(pm); }
}
