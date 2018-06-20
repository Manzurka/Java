<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Languages</title>
	</head>
	<body>
		<table>
			<thead>
				
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
				
			</thead>
		<tbody>
			<c:forEach var = "language" items = "${languages}" >
				<tr>
					<td><a href = '/languages/show/<c:out value="${language.getId()}"/>'><c:out value="${language.name}" /></a></td>
					<td><c:out value="${language.creator}" /></td>
					<td><c:out value="${language.version}" /></td>
					<td><a href = '/languages/delete/<c:out value="${language.id}"/>'>Delete  </a>
					<a href = "/languages/edit/<c:out value="${language.id}"/>">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<form:form method="POST" action="/languages/new" modelAttribute="language">
		    <form:label path="name">Name
		    <form:errors path="name"/>
		    <form:input path="name"/></form:label>
		    <br>
		    <br>
		    <form:label path="creator">Creator
		    <form:errors path="creator"/>
		    <form:input path="creator"/></form:label>
		    <br>
		    <br>
		    <form:label path="version">Version
		    <form:errors path="version"/>
		    <form:input path="version"/></form:label>
		   	<br>
		    <br>
		    <input type="submit" value="Submit"/>
		</form:form>
	</body>
</html>