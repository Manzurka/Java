<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sign in or sign up</title>
		
	</head>
	<body>
		<c:if test="${logoutMessage != null}" >
	       <span><c:out value="${logoutMessage}"></c:out></span>
	   	</c:if>
		<div class= "container">
		<div class="row">
		<div class="inline col s6">
			<h1>Register!</h1>
  
	    	<form:form method="POST" action="/registration" modelAttribute="user">
		        <p>
		            <form:label path="firstName">First Name:</form:label>
		            <form:input path="firstName"/>
		        </p>
		        <p>
		           	<form:errors path="firstName" style="color:red;" />
		        </p>
		       
		        <p>
		            <form:label path="lastName">Last Name:</form:label>
		            <form:input path="lastName"/>
		        </p>
		        <p>
		           	<form:errors path="lastName" style="color:red;" />
		        </p>
		        <p>
		            <form:label path="email">Email:</form:label>
		            <form:input path="email"/>
		        </p>
		         <p>
		           	<form:errors path="email" style="color:red;" />
		        </p>
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password path="password"/>
		        </p>
		        <p>
		           	<form:errors path="password" style="color:red;" />
		        </p>
		        
		        <p>
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation"/>
		        </p>
		        <p>
		           	<form:errors path="passwordConfirmation" style="color:red;" />
		        </p>
		        <p>
		            <form:select path ="type">
		              	<form:option value="Host"/>
		              	<form:option value="Guest"/>
		            </form:select>
		        </p>
		        <input type="submit" value="Register!"/>
	    	</form:form>
	    </div>
	    </div>
	    <div class="row">
	    <div class="inline col s6">
			<h1>Login</h1>
			
			<c:if test="${errorMessage != null}">
	        	<c:out value="${errorMessage}"></c:out>
	    	</c:if>
	    	<form method="POST" action="/login">
		        <p>
		            <label for="username">Email</label>
		            <input type="text" id="username" name="username"/>
		        </p>
		        <p>
		            <label for="password">Password</label>
		            <input type="password" id="password" name="password"/>
		        </p>
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input type="submit" value="Login!"/>
	    	</form>
	    </div>
	    </div>
	 	</div>
	 	
	   <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	</body>
</html>