package com.shreyas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.flightreservation.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
}
