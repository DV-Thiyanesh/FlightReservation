package com.thiyanu.flightreservation.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiyanu.flightreservation.dto.ReservationUpdateRequest;
import com.thiyanu.flightreservation.entities.Reservation;
import com.thiyanu.flightreservation.repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	@Autowired
	ReservationRepository reservationrespository;
	 private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

     @RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
 		LOGGER.info("Inside findReservation() and the id is:"+id);

    	  Reservation reservation =reservationrespository.findById(id).get();
    	  return reservation;
     }
          @RequestMapping("/reservation")
    	  public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
       		LOGGER.info("Inside updateReservation() and the Request are:"+request);

        	  Reservation reservation = reservationrespository.findById(request.getId()).get();
                     	  reservation.setCheckedin(request.getCheckedin());
                     	 reservation.setNoofbags(request.getNoofbags());
                   Reservation updatedreservation = reservationrespository.save(reservation);
            		LOGGER.info("Reservation Update succesfull");	
 
        	return updatedreservation;
     }


}
