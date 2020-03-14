package com.thiyanu.flightreservation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{
	
	@Column(name="CHECKED_IN")
    private Boolean checkedin;

	
	@Column(name="NUMBER_OF_BAGS")
    private int noofbags;
    @OneToOne
    private Passenger passenger;
	@OneToOne
	private Flights flight;
	
	public Boolean getCheckedin() {
		return checkedin;
	}
	public void setCheckedin(Boolean checkedin) {
		this.checkedin = checkedin;
	}
	public int getNoofbags() {
		return noofbags;
	}
	public void setNoofbags(int noofbags) {
		this.noofbags = noofbags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flights getFlight() {
		return flight;
	}
	public void setFlight(Flights flight) {
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "Reservation [checkedin=" + checkedin + ", noofbags=" + noofbags + ", passenger=" + passenger
				+ ", flight=" + flight + "]";
	}
}
