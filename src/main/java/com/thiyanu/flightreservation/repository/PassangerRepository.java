package com.thiyanu.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiyanu.flightreservation.entities.Passenger;



public interface PassangerRepository extends JpaRepository<Passenger, Long>  {

}
