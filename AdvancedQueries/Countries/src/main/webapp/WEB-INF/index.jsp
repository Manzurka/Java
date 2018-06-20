<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Queries</title>
	</head>
	<body>
		<p>Here are the tables</p>
		<div>1) Slovene Speaking Countries: 
		<p><c:out value="${sloveneCountries}"/></p>
		</div>
		<div>2) Number of cities in each Country: <c:out value="${citiesByCountries}"/></div>
		<div>3) Cities in Mexico with population:<c:out value="${citiesInMexico}"/></div>
		<div>4) Languages in each Country with a percentage greater than 89%:<c:out value="${languages}"/></div>
		<div>5) Languages in <c:out value="${countries}"/></div>
		<div>6) Countries with Constitutional Monarchy: <c:out value="${monarchyCountries}"/></div>
		<div>7) Cities In Argentina: <c:out value="${citiesInArgentina}"/></div>
		<div>8) Countries In Each Region: <c:out value="${regions}"/></div>
	</body>
</html>