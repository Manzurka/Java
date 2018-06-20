<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit your idea</title>
		<style type="text/css">
        	<%@include file="static/css/style.css" %>
        </style>
	</head>
	<body>
		<form id="logoutForm" method="POST" action="/logout" class="logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" />
	    </form>
		<a class="home" href="/ideas">Dashboard</a>
		<h3>Edit ${idea.name}</h3>
		<form:form method="POST" action="/ideas/${idea.id}/update" modelAttribute="idea">
		        <p>
		            <form:label path="name">Content: </form:label>
		            <form:input placeholder="${idea.name}" path="name"/>
		        </p>
		        <p>
		           	<form:errors path="name"/>
		        </p>
		        <input type="submit" value="Update"/>
		</form:form>
		<br>
			<a href="/ideas/${idea.id}/delete"><button>Delete</button></a>
	</body>
</html>