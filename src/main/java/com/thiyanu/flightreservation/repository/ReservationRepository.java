package com.thiyanu.flightreservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thiyanu.flightreservation.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
