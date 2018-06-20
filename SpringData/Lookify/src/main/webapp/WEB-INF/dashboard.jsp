<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dashboard</title>
	</head>
	<body>
		<a href="/songs/new">Add new</a>
		<a href="/search/topTen">Top songs</a>
	
		<form action="/search">
			<input type="text" name="search">
			<input type="submit" value="Search Artists">
		</form>
		
		<table>
			<tr>
				<th> Name </th>
				<th> Rating(1-10) </th>
				<th> Actions </th>
			</tr>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.name}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="/delete/<c:out value="${song.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
			<c:forEach var="song" items="${foundsongs}">
				<tr>
					<td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.name}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="/delete/<c:out value="${song.id}"/>">Delete</a></td>
					<td>Search result for <c:out value="${song.artist}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>