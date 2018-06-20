<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dojo Survey</title>
		<style type="text/css">
			<%@include file="css/style.css" %>
		</style>
		
	</head>
	<body>
		<form action='/result' method='post'>
	        <label for="name">Your Name:</label>
	        <input type='text' placeholder='Enter your name' name="name" id="name">
	        <br>
	        <label for="dojoLocation">Dojo Location:</label>
	        <select name="dojolocation" id="dojoLocation">
	            <option value="San Jose">San Jose</option>
	            <option value="Phoenix">Phoenix</option>
	            <option value="Seattle">Seattle</option>
	        </select>
	        <br>
	        <label for="favoriteLanguage">Favorite Language:</label>
	        <select name="favoriteLanguage" id="favoriteLanguage">
	            <option value="Java">Java</option>
	            <option value="Python">Python</option>
	            <option value="C++">C++</option>
	            <option value="JavaScript">JavaScript</option>
	            <option value="Ruby">Ruby</option>
	            <option value="PHP">PHP</option>
	        </select>
	        <br>
	        <label for="comment">Comment(optional):</label>
	        <br>
	        <textarea id="comment" name="comment"></textarea>
	        <br>
	        <input type="submit" value="Submit">
		</form>
	</body>
</html>