package com.shreyas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.flightreservation.entities.Reservation;



public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation findOne(Long id);
	
}
