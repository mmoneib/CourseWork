package com.moneib.linkedin.learning.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//Indicates the request body (parameters) for the POST endpoint.
public class ReservationRequest {
	private Long id;
	private Long roomId;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate checkin;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate checkout;

	public ReservationRequest() {
		super();
	}

	public ReservationRequest(Long id, LocalDate checkin, LocalDate checkout, Long roomId) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomId = roomId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
}
