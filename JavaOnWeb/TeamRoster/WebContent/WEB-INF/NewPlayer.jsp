<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Player</title>
<style> 
label {
	display:block;
	margin:10px;
}
input {
	display:block;
	margin:10px;
}
</style>
</head>
<body>
	<h2>Add a new player to <c:out value="${team.getTeam_name()}"/></h2>
	<form action="/TeamRoster/Players" method="post">
		<label>First Name</label><input type="text" name="first_name">
		<label>Last Name</label><input type="text" name="last_name">
		<label>Age</label><input type="number" name="age">
		<input type="submit" value="Add player">
	</form>
</body>
</html>