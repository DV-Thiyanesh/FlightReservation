package com.thiyanu.flightreservation.entities;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Flights extends AbstractEntity {
	
	@Column(name="OPERATING_AIRLINES")
	private String operatingairlines;
	
	@Column(name="DEPARTURE_CITY")
	private String departurecity;
	@Column(name="ARRIVAL_CITY")
	private String arrivalcity;
	@Column(name="DATE_OF_DEPARTURE")
	private Date dateeofdeparture;
	@Column(name="ESTIMATED_DEPARTURE_TIME")
	private Timestamp estimateddeparturetime;
	@Column(name="FLIGHT_NUMBER")
    private  String flightnumber;
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getOperatingairlines() {
		return operatingairlines;
	}
	public void setOperatingairlines(String operatingairlines) {
		this.operatingairlines = operatingairlines;
	}
	public String getDeparturecity() {
		return departurecity;
	}
	public void setDeparturecity(String departurecity) {
		this.departurecity = departurecity;
	}
	public String getArrivalcity() {
		return arrivalcity;
	}
	public void setArrivalcity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	public Date getDateeofdeparture() {
		return dateeofdeparture;
	}
	public void setDateeofdeparture(Date dateeofdeparture) {
		this.dateeofdeparture = dateeofdeparture;
	}
	public Timestamp getEstimateddeparturetime() {
		return estimateddeparturetime;
	}
	public void setEstimateddeparturetime(Timestamp estimateddeparturetime) {
		this.estimateddeparturetime = estimateddeparturetime;

}
	@Override
	public String toString() {
		return "Flights [operatingairlines=" + operatingairlines + ", departurecity=" + departurecity + ", arrivalcity="
				+ arrivalcity + ", dateeofdeparture=" + dateeofdeparture + ", estimateddeparturetime="
				+ estimateddeparturetime + ", flightnumber=" + flightnumber + "]";
	}
}