package com.thiyanu.flightreservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thiyanu.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByEmail(String email);

}
  