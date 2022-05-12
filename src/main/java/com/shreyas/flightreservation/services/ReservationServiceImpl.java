package com.shreyas.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreyas.flightreservation.controllers.ReservationController;
import com.shreyas.flightreservation.dto.ReservationRequest;
import com.shreyas.flightreservation.entities.Flight;
import com.shreyas.flightreservation.entities.Passenger;
import com.shreyas.flightreservation.entities.Reservation;
import com.shreyas.flightreservation.repos.FlightRepository;
import com.shreyas.flightreservation.repos.PassengerRepository;
import com.shreyas.flightreservation.repos.ReservationRepository;
import com.shreyas.flightreservation.util.EmailUtil;
import com.shreyas.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		//Make Payment
		//request.getCardNumber();
		
		LOGGER.info("Inside bookFlight()");
		
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for flight id" + flightId);
		Flight flight = flightRepository.findOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstname());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the info of passsenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation: " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "/Users/shreyaspaliwal/Documents/reservations/reservation" + savedReservation.getId() + ".pdf";
		LOGGER.debug("Generating the itinerary");
		pdfGenerator.generateIinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return savedReservation;
	}

}
