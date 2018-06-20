<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team info</title>
</head>
<body>

	<h1><c:out value="${team.getTeam_name()}"/></h1>
	<h2>Players</h2>
	<table> 
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="player" items="${team.getPlayers()}">
			<tr>
				<td><c:out value = "${player.getFirst_name()}"/></td>
				<td><c:out value = "${player.getLast_name()}"/></td>
				<td><c:out value = "${player.getAge()}"/></td>
				<td><a href="/TeamRoster/DeletePlayer?playerid=<c:out value= "${player.getPlayerId()}"/>">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<a href="/TeamRoster/Players">Add a new player</a>

</body>
</html>