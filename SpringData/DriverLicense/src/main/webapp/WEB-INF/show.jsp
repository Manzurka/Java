<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Profile page</title>
	</head>
	<body>
		<a href="/persons/new">Add new driver</a>
		<br>
		<a href="/licenses/new">Add license</a>
		<c:if test="${list != null}">
			<h1>List of drivers</h1>
			<c:forEach var="person" items="${list}">
				<li><a href="/show/<c:out value="${person.getId()}"/>">${person.getFullName()}</a></li>
			</c:forEach>
		</c:if>
		<c:if test="${person != null}">
			<h3><c:out value="${person.getFullName()}"/></h3>
			<h5>License Number <c:out value="${person.getLicense().getNumber()}"/></h5>
			<h5>State <c:out value="${person.getLicense().getState()}"/></h5>
			<h5>Expiration Date <c:out value="${person.getLicense().getExpiration_date()}"/></h5>
		</c:if>
	</body>
</html>