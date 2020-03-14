package com.thiyanu.flightreservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thiyanu.flightreservation.entities.Flights;

public interface FlightRepository extends JpaRepository<Flights, Long> {
     @Query("from Flights where departurecity=:departurecity and arrivalcity=:arrivalcity and dateeofdeparture=:dateeofdeparture")
	 List<Flights> findFlights(@Param("departurecity") String from, @Param("arrivalcity") String to,  @Param("dateeofdeparture") Date departuredate);

	
 
}
