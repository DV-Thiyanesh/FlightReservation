package com.thiyanu.flightreservation.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiyanu.flightreservation.dto.ReservationRequest;
import com.thiyanu.flightreservation.entities.Flights;
import com.thiyanu.flightreservation.entities.Reservation;
import com.thiyanu.flightreservation.repository.FlightRepository;
import com.thiyanu.flightreservation.service.IReservationService;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightrepository;
	
	@Autowired
	private IReservationService reservationservice;
	 private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping("/findflight")
	public String findflight(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departuredate") @DateTimeFormat(pattern = "MM-dd-yyyy") 	Date departuredate, ModelMap map ) {
		LOGGER.info("Inside findflight() from address"+from +"to address"+to+"Departure date"+departuredate);

		List<Flights> findflights = flightrepository.findFlights(from,to,departuredate);
	
		map.addAttribute("flights", findflights);
		LOGGER.info("Flight Found are:"+findflights);

		return "flight";
	}
	
	@RequestMapping("/completereservationpage")
	public String completeReservationpage(@RequestParam("flightid") Long flightid, ModelMap map) {
		LOGGER.info("completeReservationpage() and the Flight id is"+flightid);
		Flights flight = flightrepository.findById(flightid).get();
		map.addAttribute("flight", flight);
		LOGGER.info("Complete the Reservation for the Flight you have choosen are:"+flight);

		return "completereservation";
		
	}
	
	@RequestMapping(value="/completereservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap map) {
		LOGGER.info("inside completeReservation() and requested details are  "+request);

		
		Reservation reservation = reservationservice.bookFlight(request);
		
		map.addAttribute("reservation", "The Passenger has been confirmed with id:"+reservation.getId());
			
		return "reservationconfirmationpage";
		
	}
}	
