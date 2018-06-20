<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Category page</title>
	</head>
	<body>
		<h1><c:out value="${category.getName()}"/></h1>
		<h3>Products:</h3>
		<ul>
			<c:forEach var="product" items="${category.getProducts()}">	
				<li><c:out value="${product.getName()}"/></li>
			</c:forEach>
		</ul>
		<form action="/categories/<c:out value="${category.getId()}"/>/add_product" method="post">
		<select name="product_id">
			<c:forEach var="product" items="${productslist}">
				<c:if test="${!category.getProducts().contains(product)}">
					<option value="${product.getId()}" label="${product.getName()}"/>	
				</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
		</form>

	</body>
</html>