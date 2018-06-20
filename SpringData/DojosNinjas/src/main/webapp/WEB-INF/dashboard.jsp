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
	    <h3><a href="/dojos/new">Add new dojo</a></h3>
	    <h3><a href="/ninjas/new">Add new ninja</a></h3>
		<h1>List of Dojos</h1>
		<table>
			<tr>
				<th>Dojo Name:</th>
				<th>Ninja Count:</th>
			</tr>
			<tbody>
				<c:forEach var="dojo" items="${dojoslist}">
					<tr>
						<td><a href ="/dojos/<c:out value="${dojo.getId()}"/>"><c:out value="${dojo.name}"/></a></td>
						<td><c:out value="${dojo.getNinjas().size()}"/> ninjas</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>