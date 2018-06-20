<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fortran Assignment</title>
		<link rel="stylesheet" type="text/css" href= "/css/style.css">
	</head>
	<body>
		<h1>Fortran!</h1>
		<ul>
			<li><a href="/m/38/0553/0733">Set up</a></li>
			<li><a href="/m/38/0483/0345">Forms</a></li>
			<li><a href="/m/38/0553/0342">Cards</a></li>
			<li><a href="/m/26/0553/0352">Advanced</a></li>
			<li><a href="/m/26/0483/2342">Binary</a></li>
		</ul>

		<h3>Assignment: 
		<c:if test = "${assignmentNumber == 0345}">
			<span>Coding forms</span>
		</c:if>
		<c:if test = "${assignmentNumber == 2342}">
			<span>Fortran to Binary</span>
		</c:if> </h3>
		<p> The goal of this assignment is to... </p>
				
		<label><input type=checkbox>Assignment completed</label>
		
	</body>
</html>