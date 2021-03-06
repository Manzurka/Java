<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<style type="text/css">
        	<%@include file="static/css/style.css" %>
        </style>
	</head>
	<body>

		
		<div class="box">
			<h1>Register</h1>
  
	    	<form:form method="POST" action="/registration" modelAttribute="user">
		        <p>
		            <form:label path="name">Name:</form:label>
		            <form:input path="name"/>
		        </p>
		        <p>
		           	<form:errors path="name"/>
		        </p>

		        <p>
		            <form:label path="email">Email:</form:label>
		            <form:input path="email"/>
		        </p>
		         <p>
		           	<form:errors path="email" />
		        </p>
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password path="password"/>
		        </p>
		        <p>
		           	<form:errors path="password" />
		        </p>
		        
		        <p>
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation"/>
		        </p>
		        <p>
		           	<form:errors path="passwordConfirmation" />
		        </p>
		        <input type="submit" value="Register"/>
	    	</form:form>
	    </div>
	    	    
	    <div class="box">
			<h1>Login</h1>
			
			<c:if test="${errorMessage != null}">
	        	<span><c:out value="${errorMessage}"></c:out></span>
	    	</c:if>
	    	
	    	<form method="POST" action="/login">
		        <p>
		            <label for="username">Email: </label>
		            <input type="text" id="username" name="username"/>
		        </p>
		        <p>
		            <label for="password">Password: </label>
		            <input type="password" id="password" name="password"/>
		        </p>
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input type="submit" value="Login"/>
	    	</form>
	    </div>
	    
	 	<c:if test="${logoutMessage != null}" >
	       <span><c:out value="${logoutMessage}"></c:out></span>
	   	</c:if>
	</body>
</html>