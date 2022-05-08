package com.shreyas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
}
