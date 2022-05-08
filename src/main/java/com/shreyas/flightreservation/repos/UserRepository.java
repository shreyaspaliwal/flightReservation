package com.shreyas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.flightreservation.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
