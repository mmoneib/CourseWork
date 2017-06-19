package com.moneib.linkedin.learning.converter;

import org.springframework.core.convert.converter.Converter;

import com.moneib.linkedin.learning.entity.ReservationEntity;
import com.moneib.linkedin.learning.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter
		implements Converter<ReservationEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(ReservationEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();

		reservationResponse.setCheckin(source.getCheckin());
		reservationResponse.setCheckout(source.getCheckout());

		return reservationResponse;
	}

}
