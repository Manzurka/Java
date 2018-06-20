<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ninjas</title>
		<style type="text/css">
        	<%@include file="css/style.css" %>
        </style>
	</head>
	<body>
		<div id="ninjas">
		    <h1>Ninjas</h1>
		    
		   
		    <c:forEach begin="1" end="${totalPages}" var="index">
		        <a href="/pages/${index}">${index}</a>
		    </c:forEach>
		    <table class="table">
		        <thead>
		        	<th>Dojo Name</th>
		            <th>Ninja First Name</th>
		            <th>Ninja Last Name</th>
		        </thead>
		        <tbody>
		            
		            <c:forEach var="ninja" items="${ninjas.content}">                 
		            <tr>
		                <td><c:out value="${ninja[0]}"></c:out></td>
		                <td><c:out value="${ninja[1]}"></c:out></td>
		                <td><c:out value="${ninja[2]}"></c:out></td>
		        
		            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>
	</body>
</html>