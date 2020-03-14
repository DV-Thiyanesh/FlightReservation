package com.thiyanu.flightreservation.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.thiyanu.flightreservation.Util.EmailUtil;
import com.thiyanu.flightreservation.Util.PDFGenerator;
import com.thiyanu.flightreservation.dto.ReservationRequest;
import com.thiyanu.flightreservation.entities.Flights;
import com.thiyanu.flightreservation.entities.Passenger;
import com.thiyanu.flightreservation.entities.Reservation;
import com.thiyanu.flightreservation.repository.FlightRepository;
import com.thiyanu.flightreservation.repository.PassangerRepository;
import com.thiyanu.flightreservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements IReservationService {
     @Value("${com.thiyanu.flightreservation.itenary.dirpath}")
	private  String ITERNARY_DIR;

	@Autowired
	FlightRepository flightrepository;
	
	@Autowired
	PassangerRepository passangerrepository;
	
	@Autowired
	ReservationRepository reservationrepository;
	
	@Autowired
	PDFGenerator pdfgenerator;
	@Autowired
	EmailUtil emailutil;
	 
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		System.out.println("inner1");
		
	        Long flightid= request.getFlightid();
	        LOGGER.info("Inside bookFlight() adn the flight ID is:"+flightid);
	        Flights flight = flightrepository.findById(flightid).get();
			

	        Passenger passenger = new Passenger();
	        passenger.setFirstname(request.getPassengerfirstname());
	        passenger.setMiddlename(request.getPassengermiddlename());
	        passenger.setLastname(request.getPassengerlastname());
	        passenger.setEmail(request.getPassengeremail());
	        passenger.setPhone(request.getPassengerphone());
	        LOGGER.info("Saving the passenger:"+passenger);

            Passenger savedpassenger = passangerrepository.save(passenger);
	         Reservation reservation = new Reservation();
	         reservation.setFlight(flight);
	        reservation.setPassenger(savedpassenger);
	         reservation.setCheckedin(false);         
		        LOGGER.info("saving the Reservation:"+reservation);

	        Reservation savedreservation = reservationrepository.save(reservation);
	        
	        String filepath =ITERNARY_DIR+savedreservation.getId()+".pdf";
	        LOGGER.info("Generating the Itenary");
	        pdfgenerator.generateIternary(savedreservation, filepath);
	        LOGGER.info("Generating the Mail");

	        emailutil.sendIternary(passenger.getEmail(), filepath);
	        
	        return savedreservation;
	}

}
