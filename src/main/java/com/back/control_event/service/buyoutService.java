package com.back.control_event.service;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.buyout;
import com.back.control_event.repository.IBuyoutRepository;
import com.back.control_event.repository.ITicketRepository;
import com.back.control_event.model.ticket;
import org.springframework.transaction.annotation.Transactional;
import com.back.control_event.repository.IPaymentMethodRepository;
import com.back.control_event.repository.IUserRepository;
import com.back.control_event.model.paymentMethod;
import com.back.control_event.model.user;

@Service
public class buyoutService {
    @Autowired
    private IBuyoutRepository buyoutRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;
    @Autowired
    private IUserRepository userRepository;

    public List<buyout> getAll() { return buyoutRepository.findAll(); }
    public buyout getById(int id) { return buyoutRepository.findById(id).orElse(null); }
    public buyout save(buyout b) { return buyoutRepository.save(b); }
    public buyout update(buyout b) { return buyoutRepository.save(b); }

    @Transactional
    public buyout create(buyout b) {
        if (b.getTicket() == null || b.getTicket().getId_ticket() == 0) {
            throw new IllegalArgumentException("ticket es obligatorio");
        }
        if (b.getPayMethod() == null) {
            throw new IllegalArgumentException("payMethod es obligatorio");
        }
        if (b.getUser() == null || b.getUser().getId_user() == 0) {
            throw new IllegalArgumentException("user es obligatorio");
        }
        int qty = b.getTicket_number();
        if (qty <= 0) {
            throw new IllegalArgumentException("ticket_number debe ser mayor a 0");
        }
        if (qty > 10) {
            throw new IllegalArgumentException("ticket_number no puede ser mayor a 10");
        }

        ticket t = ticketRepository.findById(b.getTicket().getId_ticket())
            .orElseThrow(() -> new IllegalArgumentException("ticket no encontrado: id=" + b.getTicket().getId_ticket()));

        // Resolver referencias existentes para evitar entidades transientes
        int payId = b.getPayMethod().getId_pay_method();
        if (payId == 0) {
            throw new IllegalArgumentException("payMethod.id_pay_method es obligatorio");
        }
        paymentMethod pm = paymentMethodRepository.findById(payId)
            .orElseThrow(() -> new IllegalArgumentException("paymentMethod no encontrado: id=" + payId));
        b.setPayMethod(pm);

        int userId = b.getUser().getId_user();
        user u = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("user no encontrado: id=" + userId));
        b.setUser(u);

        if (t.getCount() < qty) {
            throw new IllegalArgumentException("no hay suficientes boletas disponibles");
        }

        // Calcular totales y fecha de pago
        BigDecimal unitValue = t.getValue();
        if (unitValue == null) {
            throw new IllegalArgumentException("el ticket no tiene valor configurado");
        }
        BigDecimal total = unitValue.multiply(BigDecimal.valueOf(qty));
        b.setValue_total(total);
        b.setDate_payment(new Date());

        // Descontar inventario
        t.setCount(t.getCount() - qty);
        ticketRepository.save(t);

        return buyoutRepository.save(b);
    }
}
