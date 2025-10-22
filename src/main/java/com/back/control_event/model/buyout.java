package com.back.control_event.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "userTicket")
public class buyout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_ticket")
    private int id_user_ticket;

    @Column(name = "ticket_number", nullable = false)
    private int ticket_number;

    @Column(name = "value_total", nullable = false)
    private BigDecimal value_total;

    @Column(name = "state_pay", nullable = false)
    private int state_pay;

    @Column(name = "date_payment", nullable = false)
    private Date date_payment;

    @ManyToOne
    @JoinColumn(name = "id_pay_method", nullable = false)
    private paymentMethod payMethod;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "id_ticket", nullable = false)
    private ticket ticket;

    public buyout() {}

    public int getId_user_ticket() { return id_user_ticket; }
    public void setId_user_ticket(int id_user_ticket) { this.id_user_ticket = id_user_ticket; }
    public int getTicket_number() { return ticket_number; }
    public void setTicket_number(int ticket_number) { this.ticket_number = ticket_number; }
    public BigDecimal getValue_total() { return value_total; }
    public void setValue_total(BigDecimal value_total) { this.value_total = value_total; }
    public int getState_pay() { return state_pay; }
    public void setState_pay(int state_pay) { this.state_pay = state_pay; }
    public Date getDate_payment() { return date_payment; }
    public void setDate_payment(Date date_payment) { this.date_payment = date_payment; }
    public paymentMethod getPayMethod() { return payMethod; }
    public void setPayMethod(paymentMethod payMethod) { this.payMethod = payMethod; }
    public user getUser() { return user; }
    public void setUser(user user) { this.user = user; }
    public ticket getTicket() { return ticket; }
    public void setTicket(ticket ticket) { this.ticket = ticket; }
}
