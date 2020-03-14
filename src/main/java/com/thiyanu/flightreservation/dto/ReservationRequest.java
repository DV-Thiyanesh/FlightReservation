package com.thiyanu.flightreservation.dto;

public class ReservationRequest {
	
	

	private Long flightid;
	private String passengerfirstname;
	private String passengermiddlename;
	private String passengerlastname;
	private String passengeremail;
	private String passengerphone;
	private String nameofthecard;
	private String cardnumber;
	private String expirationdate;
	private String securitycode;

	public String getPassengerfirstname() {
		return passengerfirstname;
	}
	public void setPassengerfirstname(String passengerfirstname) {
		this.passengerfirstname = passengerfirstname;
	}
	public String getPassengerlastname() {
		return passengerlastname;
	}
	public void setPassengerlastname(String passengerlastname) {
		this.passengerlastname = passengerlastname;
	}
	public String getPassengeremail() {
		return passengeremail;
	}
	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}
	public String getPassengerphone() {
		return passengerphone;
	}
	public void setPassengerphone(String passengerphone) {
		this.passengerphone = passengerphone;
	}
	public Long getFlightid() {
		return flightid;
	}
	public void setFlightid(Long flightid) {
		this.flightid = flightid;
	}
	public String getNameofthecard() {
		return nameofthecard;
	}
	public void setNameofthecard(String nameofthecard) {
		this.nameofthecard = nameofthecard;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}
	public String getSecuritycode() {
		return securitycode;
	}
	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}
	public String getPassengermiddlename() {
		return passengermiddlename;
	}
	public void setPassengermiddlename(String passengermiddlename) {
		this.passengermiddlename = passengermiddlename;
	}
	@Override
	public String toString() {
		return "ReservationRequest [flightid=" + flightid + ", passengerfirstname=" + passengerfirstname
				+ ", passengermiddlename=" + passengermiddlename + ", passengerlastname=" + passengerlastname
				+ ", passengeremail=" + passengeremail + ", passengerphone=" + passengerphone + ", nameofthecard="
				+ nameofthecard + ", cardnumber=" + cardnumber + ", expirationdate=" + expirationdate
				+ ", securitycode=" + securitycode + "]";
	}
}
