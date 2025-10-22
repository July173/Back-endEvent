package com.back.control_event.dto;

import java.math.BigDecimal;
import java.util.Date;

public class BuyoutHistoryDTO {
    private String eventName;
    private String locatedName;
    private int ticketNumber;
    private BigDecimal valueTotal;
    private Date datePayment;
    private int statePay;

    public BuyoutHistoryDTO(String eventName, String locatedName, int ticketNumber, BigDecimal valueTotal, Date datePayment, int statePay) {
        this.eventName = eventName;
        this.locatedName = locatedName;
        this.ticketNumber = ticketNumber;
        this.valueTotal = valueTotal;
        this.datePayment = datePayment;
        this.statePay = statePay;
    }

    public String getEventName() { return eventName; }
    public String getLocatedName() { return locatedName; }
    public int getTicketNumber() { return ticketNumber; }
    public BigDecimal getValueTotal() { return valueTotal; }
    public Date getDatePayment() { return datePayment; }
    public int getStatePay() { return statePay; }
}
