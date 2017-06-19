package com.moneib.linkedin.learning.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneib.linkedin.learning.converter.RoomEntityToReservableRoomResponseConverter;
import com.moneib.linkedin.learning.entity.ReservationEntity;
import com.moneib.linkedin.learning.entity.RoomEntity;
import com.moneib.linkedin.learning.model.request.ReservationRequest;
import com.moneib.linkedin.learning.model.response.ReservableRoomResponse;
import com.moneib.linkedin.learning.model.response.ReservationResponse;
import com.moneib.linkedin.learning.repository.PageableRoomRepository;
import com.moneib.linkedin.learning.repository.ReservationRepository;
import com.moneib.linkedin.learning.repository.RoomRepository;

@RestController
@RequestMapping(value = ResourceConstants.ROOM_RESERVATION_V1)
/*
 * The CrossOrigin annotation allows calls from different domains. While a Same
 * Origin (default) should be maintained in production for security reasons, in
 * the local envirionment, since we are using 2 different host:port
 * combinations, they are considered as different domains.
 */
@CrossOrigin
public class ReservationResource {

	@Autowired
	PageableRoomRepository pageableRoomRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			// By default, any request parameter is set to required (server-side
			// validation). Also, the strongly typed parameter insures that the
			// data is in a certain format.
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			Pageable pageable) {

		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);

		return roomEntityList.map(new RoomEntityToReservableRoomResponseConverter());
	}

	// Spring's expression language is used in the path to reference the
	// path variable passed to the method.
	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {

		RoomEntity roomEntity = roomRepository.findById(roomId);

		return new ResponseEntity<RoomEntity>(roomEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {

		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
		reservationRepository.save(reservationEntity);

		RoomEntity roomEntity = roomRepository.findById(reservationRequest.getRoomId());
		roomEntity.addReservationEntity(reservationEntity);
		roomRepository.save(roomEntity);
		reservationEntity.setRoomEntity(roomEntity);
		// reservationRepository.save(reservationEntity);

		ReservationResponse reservationResponse = conversionService.convert(reservationEntity,
				ReservationResponse.class);

		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateeReservation(
			@RequestBody ReservationRequest reservationRequest) {

		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
