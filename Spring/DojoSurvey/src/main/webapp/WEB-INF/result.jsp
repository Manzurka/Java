<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Results</title>
	</head>
<body>
    <h1>Submitted Info</h1>
    <h2>Name: <c:out value="${name}"/></h2>
    <h2>Dojo Location:<c:out value="${location}"/></h2>
    <h2>Favorite Language:  <c:out value="${language}"/></h2>
    <h2>Comment <c:out value="${comment}"/></h2>
    <a href="/"><button>Go Back</button></a> 
</body>
</html>