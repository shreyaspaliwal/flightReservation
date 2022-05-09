package com.shreyas.flightreservation.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.flightreservation.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
