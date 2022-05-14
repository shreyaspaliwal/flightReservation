package com.shreyas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
