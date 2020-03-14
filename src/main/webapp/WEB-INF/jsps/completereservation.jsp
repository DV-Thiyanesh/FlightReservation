<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation</h2>
Airlines       ${flight.operatingairlines}</br>
Departure City ${flight.departurecity}</br>
Departure Date ${flight.estimateddeparturetime}

<form action="completereservation" method="post">
<pre>	
<h2>Passenger Details:</h2>
First Name 		 <input type="text" name="passengerfirstname"/>
Middle Name  		 <input type="text" name="passengermiddlename"/>
Last Name  		 <input type="text" name="passengerlastname"/>
Email            <input type="text" name="passengeremail"/>
Phone            <input type="text" name="passengerphone"/>

<h2>Card Details:</h2>
Name of the card:     <input type="text" name="nameofthecard"/>
card no:  		      <input type="text" name="cardnumber"/>
Expiry Date:          <input type="text" name="expirationdate"/>
Three Digit Sec Code: <input type="text" name="securitycode"/>
</pre>
<input type="hidden" name="flightid" value="${flight.id}"/>
<input type="submit" value="Save"/>
</form>
</body>
</html>