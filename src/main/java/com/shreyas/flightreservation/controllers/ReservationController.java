package com.shreyas.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shreyas.flightreservation.dto.ReservationRequest;
import com.shreyas.flightreservation.entities.Flight;
import com.shreyas.flightreservation.entities.Reservation;
import com.shreyas.flightreservation.repos.FlightRepository;
import com.shreyas.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository; 
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("showCompleteReservation() invoked with the Flight ID: " + flightId);
		Flight flight = flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is: " + flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("completeReservation()" + request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is : " + reservation.getId());
		return "reservationConfirmation";
	}
}
