<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dashboard</title>
	</head>
	<body>
		<form id="logoutForm" method="POST" action="/logout" style="float:right;">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" />
	    </form>
		<h3>Current listings</h3>
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
        <c:forEach var="listing" items="${mylistings}">
          <tr>
            <td>${listing.address}</td>
            <td>${listing.poolSize}</td>
            <td>${listing.cost}</td>
            <td><a href="/listing/${listing.id}/edit">Edit</a></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <div>
      <form:form method="POST" action="/addListing" modelAttribute="listing">
		        <p>
		            <form:label path="address">Address:</form:label>
		            <form:input path="address"/>
		        </p>
		        <p>
		           	<form:errors path="address" style="color:red;" />
		        </p>
		       
		        <p>
		            <form:label path="description">Description:</form:label>
		            <form:input path="description"/>
		        </p>
		        <p>
		           	<form:errors path="description" style="color:red;" />
		        </p>
		        <p>
		            <form:label path="cost">Cost per night($):</form:label>
		            <form:input path="cost"/>
		        </p>
		         <p>
		           	<form:errors path="cost" style="color:red;" />
		        </p>
		        <p>
		            <form:label path="poolSize">Pool size:</form:label>
		            <form:select path="poolSize">
		       
		            	<form:option value="small">Small</form:option>
		            	<form:option value="medium">Medium</form:option>
		            	<form:option value="large">Large</form:option>
		            </form:select>
		        </p>
		         <p>
		           	<form:errors path="poolSize" style="color:red;" />
		        </p>
		        <input type="submit" value="Add Listing"/>
		  </form:form>
      </div>
      
	</body>
</html>