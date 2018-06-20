<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Number Game</title>
	<style>
		body {
			text-align:center;
			}
		.red {
			margin-left:400px;
			background: red;
			width:100px;
			color: white;
			text-align:center;
			padding:30px;
			}
		.green {
			margin-left:400px;
			background: green;
			width:100px;
			color: white;
			text-align:center;
			padding:30px;
			}
	</style>
</head>
<body>
	<h1>Welcome to the Great Number Game!</h1>
    <h2>I am thinking of a number between 1 and 100</h2> <c:out value="${number}"/>
    <h2>Take a guess!</h2>
    
   
	<c:if test ="${userNum < number}">
	    <div class="red">
	    	Too low
	    </div>
    </c:if>
    <c:if test ="${userNum > number}">
	    <div class="red">
	    	Too high
	    </div>
    </c:if>
    <c:if test ="${userNum == number}">
	    <div class="green">
	    	Just right. Number is <c:out value="${number}"/>
	    	<form action="/GreatNumberGame/RandomNumbers" method="post">
				<input type="hidden" name="playagain" value="true">
				<input type="submit" value="Play Again">
			</form>
	    </div>
	</c:if>
	<br>
	<form action='/GreatNumberGame/RandomNumbers' method='post'>
    	<input name="number" type="text">
    	<input type="submit" value="Submit">
    </form>
   
</body>
</html>