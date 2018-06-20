<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Details</title>
	</head>
	<body>
		<form id="logoutForm" method="POST" action="/logout" style="float:right;">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" />
	    </form>
	    <a href="/dashboard">Home</a>
		<div>
			<h3>${listing.address}</h3>
			<p>${listing.description}</p>
		</div>
		<div>
			<p>Name: ${listing.host.firstName} ${listing.host.lastName}</p>
			<p>Email: ${listing.host.email}</p>
			<p>Pool Size: ${listing.poolSize}</p>
			<p>Cost: ${listing.cost}</p>
		</div>
		<a href="/listing/${listing.id}/review">Leave a review</a>
		<p>Reviews:
		<c:if test="${average > 0}">
			<span>${average} out of 5</span>
		</c:if></p>	<hr>

		<div>
			<c:forEach var="review" items="${listing.getReviews()}">
				<p><c:out value="${review.reviewer.firstName}"/></p>
				<p>Rating: <c:out value="${review.rating}"/></p>
				<p><c:out value="${review.review}"/></p>
				<hr>
			</c:forEach>
		</div>
	</body>
</html>