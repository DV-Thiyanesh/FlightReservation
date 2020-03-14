package com.thiyanu.flightreservation.service;

import com.thiyanu.flightreservation.dto.ReservationRequest;
import com.thiyanu.flightreservation.entities.Reservation;

public interface IReservationService {

	public Reservation bookFlight(ReservationRequest request); 
	
}
