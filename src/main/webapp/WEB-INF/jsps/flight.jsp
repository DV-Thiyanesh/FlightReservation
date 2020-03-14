<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>'
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
<table>
<tr>
<th>Airlines</th>
<th>Departure City</th>
<th>Departure Time</th>

</tr>
<c:forEach items="${flights}" var="flights"> 
<tr>
<td>${flights.operatingairlines}</td>
<td>${flights.departurecity}</td>
<td>${flights.estimateddeparturetime}</td>

<td>
<a href="completereservationpage?flightid=${flights.id}">Select</a></td> 

</tr>
</c:forEach>
</table>
</body>
</html>