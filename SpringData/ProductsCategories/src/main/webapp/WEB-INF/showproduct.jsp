<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product page</title>
	</head>
	<body>
	    <h1><c:out value="${product.name}"/></h1>
		<h3>Categories:</h3>
		<ul>
			<c:forEach var="category" items="${product.getCategories()}">	
				<li><c:out value="${category.getName()}"/></li>
			</c:forEach>
		</ul>
		<form action="/products/<c:out value="${product.getId()}"/>/add_category" method="post">
		<select name="category_id">
			<c:forEach var="category" items="${categorieslist}">
				<c:if test="${!product.getCategories().contains(category)}">
					<option value="${category.getId()}" label="${category.getName()}"/>	
				</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
		</form>
	</body>
</html>