<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
		
	</head>
	<body>
		<form id="logoutForm" method="POST" action="/logout" style="float:right;">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" />
	    </form>
		<a href="/">Home</a>
	<h3>Welcome ${currentUser.firstName}!</h3>
		<div class="row">
		<div class="input-field col s3">
		<h5>Find your pool!</h5>
		<form method="post" action="/search">
				<input type="text" placeholder="location"/>
				<input class="btn" type="submit" value="Search"/>
		</form>
		</div>
		</div>
		<table class="striped">
        <thead>
          <tr>
              <th>Address</th>
              <th>Pool size</th>
              <th>Cost per night</th>
              <th>Details</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach var="listing" items="${listings}">
          <tr>
            <td>${listing.address}</td>
            <td>${listing.poolSize}</td>
            <td>${listing.cost}</td>
            <td><a href="/listing/${listing.id}">See more</a></td>
          </tr>
          </c:forEach>
         
        </tbody>
      </table>
            
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	</body>
</html>