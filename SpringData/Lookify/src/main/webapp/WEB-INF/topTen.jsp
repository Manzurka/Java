<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search</title>
	</head>
	<body>
		<h3>Top Ten Songs:</h3>
		<a href="/dashboard">Dashboard</a>
			<ul>
			<c:forEach var="song" items="${topsongs}">
					<li><c:out value="${song.rating}"/>  - <a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.name}"/></a> - 
					<c:out value="${song.artist}"/></li>
			</c:forEach>
			</ul>
	</body>
</html>