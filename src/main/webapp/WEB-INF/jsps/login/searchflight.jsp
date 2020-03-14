<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search</title>
</head>
<body>
<h2>Find Flight</h2>
<form action="findflight" method="post">
<pre>

From            <input type="text" name="from"/>
To              <input type="text" name="to"/>
Departure Date  <input type="text" name="departuredate"/>
                <input type="submit" value="Find"/>
</pre>

</form>
</body>
</html>