package com.moneib.linkedin.learning.converter;

import org.springframework.core.convert.converter.Converter;

import com.moneib.linkedin.learning.entity.RoomEntity;
import com.moneib.linkedin.learning.model.Links;
import com.moneib.linkedin.learning.model.Self;
import com.moneib.linkedin.learning.model.response.ReservableRoomResponse;
import com.moneib.linkedin.learning.rest.ResourceConstants;

//This class performs conversion from Room's representation in the database model
//to its representation in the service layer.
//This keeps lots of logic outside the controller.
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));

		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}

}
