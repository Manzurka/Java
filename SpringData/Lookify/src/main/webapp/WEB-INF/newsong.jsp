<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add song</title>
	</head>
	<body>
		<a href="/dashboard">Dashboard</a>
		<form:form action="/add" method="post" modelAttribute="song">
			<form:label path= "name">Name
			<form:errors path="name"/>
			<form:input path="name"/></form:label>
			
			<form:label path= "artist">Artist
			<form:errors path="artist"/>
			<form:input path="artist"/></form:label>
			
			<form:label path= "rating">Rating(1-10)
			<form:errors path="rating"/>
			<form:select path="rating">
			   		<form:option value="1"/>
			   		<form:option value="2"/>
			   		<form:option value="3"/>
			   		<form:option value="4"/>
			   		<form:option value="5"/>
			   		<form:option value="6"/>
			   		<form:option value="7"/>
			   		<form:option value="8"/>
			   		<form:option value="9"/>
			   		<form:option value="10"/>
			</form:select>
			<input type="submit" value="Submit"/>
			</form:label>
		</form:form>
	</body>
</html>