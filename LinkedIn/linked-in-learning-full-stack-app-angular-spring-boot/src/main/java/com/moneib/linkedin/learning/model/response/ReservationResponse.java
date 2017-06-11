package com.moneib.linkedin.learning.model.response;

import com.moneib.linkedin.learning.model.Links;

public class ReservationResponse {
	private long id;
	private Integer roomNumber;
	private Integer price;
	private Links links;

	
	public ReservationResponse() {
		super();
	}
	
	
	public ReservationResponse(Integer number, Integer price) {
		super();
		this.roomNumber=number;
		this.price=price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
}
