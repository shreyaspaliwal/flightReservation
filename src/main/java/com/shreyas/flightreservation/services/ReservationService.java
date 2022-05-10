package com.shreyas.flightreservation.services;

import com.shreyas.flightreservation.dto.ReservationRequest;
import com.shreyas.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
}
