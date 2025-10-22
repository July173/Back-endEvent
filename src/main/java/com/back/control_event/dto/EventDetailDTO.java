package com.back.control_event.dto;

import java.util.List;
import com.back.control_event.model.event;
import com.back.control_event.model.ticket;
import com.back.control_event.model.artist;

public class EventDetailDTO {
    private event event;
    private List<ticket> tickets;
    private List<artist> artists;

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
    public List<artist> getArtists() {
        return artists;
    }
    public void setArtists(List<artist> artists) {
        this.artists = artists;
    }
}
