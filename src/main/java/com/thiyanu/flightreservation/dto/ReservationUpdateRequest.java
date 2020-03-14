package com.thiyanu.flightreservation.dto;

public class ReservationUpdateRequest {
	
	
	public Long id;
  
	public Boolean checkedin;
	public int noofbags;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	  @Override
		public String toString() {
			return "ReservationUpdateRequest [id=" + id + ", checkedin=" + checkedin + ", noofbags=" + noofbags + "]";
		}
}
