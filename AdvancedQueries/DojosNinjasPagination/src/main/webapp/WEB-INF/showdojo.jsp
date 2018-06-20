<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dojo Page</title>
	</head>
	<body>
	    <h1><c:out value="${dojo.getLocation()}"/> ninjas</h1>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
			<tbody>
				<c:forEach var="ninja" items="${dojo.getNinjas()}">
					<tr>
					<td><c:out value="${ninja.getFirstName()}"/></td>
					<td><c:out value="${ninja.getLastName()}"/></td>
					<td><c:out value="${ninja.getAge()}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>