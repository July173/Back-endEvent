package com.back.control_event.model;

import jakarta.persistence.*;

@Entity(name = "artistEvent")
public class artistEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_artist_event")
	private int id_artist_event;

	@ManyToOne
	@JoinColumn(name = "id_artist", nullable = false)
	private artist artist;

	@ManyToOne
	@JoinColumn(name = "id_event", nullable = false)
	private event event;

	public artistEvent() {}

	public artistEvent(artist artist, event event, int id_artist_event) {
		this.artist = artist;
		this.event = event;
		this.id_artist_event = id_artist_event;
	}

	public int getId_artist_event() {
		return id_artist_event;
	}

	public void setId_artist_event(int id_artist_event) {
		this.id_artist_event = id_artist_event;
	}

	public artist getArtist() {
		return artist;
	}

	public void setArtist(artist artist) {
		this.artist = artist;
	}

	public event getEvent() {
		return event;
	}

	public void setEvent(event event) {
		this.event = event;
	}
}

