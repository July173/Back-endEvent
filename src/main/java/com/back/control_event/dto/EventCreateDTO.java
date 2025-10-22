package com.back.control_event.dto;

import java.util.List;
import com.back.control_event.model.event;
import com.back.control_event.model.ticket;

public class EventCreateDTO {
    private event event;
    private List<ticket> tickets;
    private List<Integer> artistIds;

    public event getEvent() {
        return event;
    }
    public void setEvent(event event) {
        this.event = event;
    }
    public List<ticket> getTickets() {
        return tickets;
    }
    public void setTickets(List<ticket> tickets) {
        this.tickets = tickets;
    }
    public List<Integer> getArtistIds() {
        return artistIds;
    }
    public void setArtistIds(List<Integer> artistIds) {
        this.artistIds = artistIds;
    }
}
