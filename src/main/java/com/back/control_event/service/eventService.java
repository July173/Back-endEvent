package com.back.control_event.service;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.event;
import com.back.control_event.model.ticket;
import com.back.control_event.model.artistEvent;
import com.back.control_event.model.artist;
import com.back.control_event.model.municipio;
import com.back.control_event.model.locatedEvent;
import com.back.control_event.repository.IEventRepository;
import com.back.control_event.repository.ITicketRepository;
import com.back.control_event.repository.IArtistEventRepository;
import com.back.control_event.repository.IArtistRepository;
import com.back.control_event.repository.IMunicipioRepository;
import com.back.control_event.repository.ILocatedEventRepository;
import com.back.control_event.dto.EventCreateDTO;
import com.back.control_event.dto.EventDetailDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
public class eventService {
    @Autowired
    private IEventRepository eventRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private IArtistEventRepository artistEventRepository;
    @Autowired
    private IArtistRepository artistRepository;
    @Autowired
    private IMunicipioRepository municipioRepository;
    @Autowired
    private ILocatedEventRepository locatedEventRepository;

    public List<event> getAll() {
        return eventRepository.findAll();
    }

    public event getById(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    public event save(event event) {
        return eventRepository.save(event);
    }

    public event update(event event) {
        return eventRepository.save(event);
    }

    @Transactional
    public event createEvent(EventCreateDTO dto) {
        // Validate existence
        event incoming = dto.getEvent();
        if (incoming.getMunicipio() == null) {
            throw new IllegalArgumentException("municipio es obligatorio");
        }
        int munId = incoming.getMunicipio().getId_municipio();
        if (!municipioRepository.existsById(munId)) {
            throw new IllegalArgumentException("municipio no encontrado: id=" + munId);
        }
        municipio munRef = municipioRepository.getReferenceById(munId);
        incoming.setMunicipio(munRef);

        // Validate tickets locatedEvent
        if (dto.getTickets() != null) {
            for (ticket t : dto.getTickets()) {
                if (t.getLocatedEvent() == null) {
                    throw new IllegalArgumentException("ticket.locatedEvent es obligatorio");
                }
                int locId = t.getLocatedEvent().getId_located_event();
                if (!locatedEventRepository.existsById(locId)) {
                    throw new IllegalArgumentException("locatedEvent no encontrado: id=" + locId);
                }
            }
        }

        // Validate artistIds
        if (dto.getArtistIds() != null) {
            for (Integer artistId : dto.getArtistIds()) {
                if (artistId == null || !artistRepository.existsById(artistId)) {
                    throw new IllegalArgumentException("artist no encontrado: id=" + artistId);
                }
                // Validar solapamiento de agenda del artista con el rango del evento a crear
                Date start = incoming.getDate_start();
                Date end = incoming.getDate_end();
                if (start == null || end == null) {
                    throw new IllegalArgumentException("date_start y date_end son obligatorios");
                }
                boolean conflict = artistEventRepository.existsArtistScheduleConflict(artistId, start, end);
                if (conflict) {
                    throw new IllegalArgumentException("conflicto de agenda: el artista id=" + artistId + " ya está asignado a otro evento en el mismo horario/día");
                }
            }
        }

        event savedEvent = eventRepository.save(incoming);
        // Asignar código autoincremental basado en el id generado
        if (savedEvent.getCode() == 0) {
            savedEvent.setCode(savedEvent.getId_event());
            savedEvent = eventRepository.save(savedEvent);
        }
        for (ticket t : dto.getTickets()) {
            if (t.getLocatedEvent() != null) {
                int locId = t.getLocatedEvent().getId_located_event();
                locatedEvent locRef = locatedEventRepository.getReferenceById(locId);
                t.setLocatedEvent(locRef);
            }
            t.setEvent(savedEvent);
            ticketRepository.save(t);
        }
        for (Integer artistId : dto.getArtistIds()) {
            artist artist = artistRepository.findById(artistId).orElse(null);
            if (artist != null) {
                artistEvent ae = new artistEvent();
                ae.setEvent(savedEvent);
                ae.setArtist(artist);
                artistEventRepository.save(ae);
            }
        }
        return savedEvent;
    }

    public void setEventStatus(int id, int status) {
        event e = eventRepository.findById(id).orElse(null);
        if (e != null) {
            e.setStatus(status);
            eventRepository.save(e);
        }
    }

    public List<event> getEventsByFilters(Integer municipioId, Integer departmentId, Date startDate, Date endDate, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return eventRepository.search(filter);
        }
        if (municipioId != null) {
            return eventRepository.findByMunicipio(municipioId);
        }
        if (departmentId != null) {
            return eventRepository.findByDepartment(departmentId);
        }
        if (startDate != null && endDate != null) {
            return eventRepository.findByDateRange(startDate, endDate);
        }
        return eventRepository.findAll();
    }

    public EventDetailDTO getEventDetail(int id) {
        event e = eventRepository.findById(id).orElse(null);
        if (e == null) {
            return null;
        }
        List<ticket> tickets = ticketRepository.findByEventId(id);
        List<artist> artists = artistEventRepository.findArtistsByEventId(id);
        EventDetailDTO dto = new EventDetailDTO();
        dto.setEvent(e);
        dto.setTickets(tickets);
        dto.setArtists(artists);
        return dto;
    }

    @Transactional
    public event updateEvent(EventCreateDTO dto, int id) {
        event existing = eventRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        event incoming = dto.getEvent();
        incoming.setId_event(id);
        if (incoming.getMunicipio() == null) {
            throw new IllegalArgumentException("municipio es obligatorio");
        }
        int munId = incoming.getMunicipio().getId_municipio();
        if (!municipioRepository.existsById(munId)) {
            throw new IllegalArgumentException("municipio no encontrado: id=" + munId);
        }
        municipio munRef = municipioRepository.getReferenceById(munId);
        incoming.setMunicipio(munRef);

        event saved = eventRepository.save(incoming);

        artistEventRepository.deleteByEventId(id);
        ticketRepository.deleteByEventId(id);

        // Validate tickets locatedEvent
        if (dto.getTickets() != null) {
            for (ticket t : dto.getTickets()) {
                if (t.getLocatedEvent() == null) {
                    throw new IllegalArgumentException("ticket.locatedEvent es obligatorio");
                }
                int locId = t.getLocatedEvent().getId_located_event();
                if (!locatedEventRepository.existsById(locId)) {
                    throw new IllegalArgumentException("locatedEvent no encontrado: id=" + locId);
                }
            }
        }

        for (ticket t : dto.getTickets()) {
            int locId = t.getLocatedEvent().getId_located_event();
            locatedEvent locRef = locatedEventRepository.getReferenceById(locId);
            t.setLocatedEvent(locRef);
            t.setEvent(saved);
            ticketRepository.save(t);
        }
        // Validate artistIds y solapamiento de agenda (excluyendo este evento)
        if (dto.getArtistIds() != null) {
            for (Integer artistId : dto.getArtistIds()) {
                if (artistId == null || !artistRepository.existsById(artistId)) {
                    throw new IllegalArgumentException("artist no encontrado: id=" + artistId);
                }
                Date start = incoming.getDate_start();
                Date end = incoming.getDate_end();
                if (start == null || end == null) {
                    throw new IllegalArgumentException("date_start y date_end son obligatorios");
                }
                boolean conflict = artistEventRepository.existsArtistScheduleConflictExcludingEvent(artistId, start, end, id);
                if (conflict) {
                    throw new IllegalArgumentException("conflicto de agenda: el artista id=" + artistId + " ya está asignado a otro evento en el mismo horario/día");
                }
            }
        }

        for (Integer artistId : dto.getArtistIds()) {
            artist artist = artistRepository.findById(artistId).orElse(null);
            if (artist != null) {
                artistEvent ae = new artistEvent();
                ae.setEvent(saved);
                ae.setArtist(artist);
                artistEventRepository.save(ae);
            }
        }
        return saved;
    }
}
