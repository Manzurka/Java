<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fortran Lesson</title>
		<link rel="stylesheet" type="text/css" href= "/css/style.css">
	</head>
	<body>
		<h1>Fortran!</h1>
		<ul>
			<li><a href="/m/38/0553/0733">Set up</a></li>
			<li><a href="/m/38/0483/0345">Forms</a></li>
			<li><a href="/m/38/0553/0342">Cards</a></li>
			<li><a href="/m/26/0553/0348">Advanced</a></li>
			<li><a href="/m/26/0483/2342">Binary</a></li>
		</ul>
		<h2>Chapter <c:out value="${chapter}"/> 
		<c:if test = "${lessonNumber == 0733}">
			<span>Setting up your servers</span>
		</c:if>
		<c:if test = "${lessonNumber == 0342}">
			<span>Punch cards</span>
		</c:if>
		<c:if test = "${lessonNumber == 0348}">
			<span>Advanced Fortran Info</span>
		</c:if>
		placeholder</h2>
	</body>
</html>