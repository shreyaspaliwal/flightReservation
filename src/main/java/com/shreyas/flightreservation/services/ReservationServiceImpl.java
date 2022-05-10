package com.shreyas.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreyas.flightreservation.dto.ReservationRequest;
import com.shreyas.flightreservation.entities.Flight;
import com.shreyas.flightreservation.entities.Passenger;
import com.shreyas.flightreservation.entities.Reservation;
import com.shreyas.flightreservation.repos.FlightRepository;
import com.shreyas.flightreservation.repos.PassengerRepository;
import com.shreyas.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		//Make Payment
		//request.getCardNumber();
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstname());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
