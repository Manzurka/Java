<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show Language</title>
	</head>
	<body>
			<a href="/languages">Dashboard</a>
			<ul>
				<li><c:out value="${language.name}" /></li>
				<li><c:out value="${language.creator}" /></li>
				<li><c:out value="${language.version}" /></li>
				<li><a href = '/languages/delete/<c:out value="${language.id}"/>'>Delete</a></li>
				<li><a href = '/languages/edit/<c:out value="${language.id}"/>'>Edit</a></li>
			</ul>
	</body>
</html>