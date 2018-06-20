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
		<a href="/dashboard">Dashboard</a>
		<h3>Title: <c:out value="${song.name}"/></h3>
		<h3>Artist: <c:out value="${song.artist}"/></h3>
		<h3>Rating(1-10): <c:out value="${song.rating}"/></h3>
		<a href="/delete/<c:out value="${song.id}"/>">Delete</a>
	</body>
</html>