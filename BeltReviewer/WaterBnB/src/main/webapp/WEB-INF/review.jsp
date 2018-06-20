<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Review</title>
	</head>
	<body>
	<form id="logoutForm" method="POST" action="/logout" style="float:right;">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" />
	    </form>
	    <a href="/dashboard">Home</a>
	<h3>Review of ${listing.address}</h3>
		<form:form method="POST" action="/listing/${listing.id}/addreview" modelAttribute="r">
		        <p>
		            <form:label path="review">Add review:</form:label>
		            <form:input path="review"/>
		        </p>
		        <p>
		           	<form:errors path="review" style="color:red;" />
		        </p>
		        <p>
		            <form:label path="rating">Rating:</form:label>
		            <form:select path="rating">
		       			<form:options items="${numbers}"/>
		            </form:select>
		        </p>
		        <input type="submit" value="Add Review"/>
		  </form:form>
	</body>
</html>