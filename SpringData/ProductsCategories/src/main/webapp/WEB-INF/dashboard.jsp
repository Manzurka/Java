<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>All products and categories</title>
	</head>
	<body>
		<h1>Products</h1>
		<a href="/products/new">Add a product</a>
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Category Count</th>
			</tr>
			<tbody>
				<c:forEach var="product" items="${productslist}">
					<tr>
						<td><a href ="/products/<c:out value="${product.getId()}"/>"><c:out value="${product.name}"/></a></td>
						<td><c:out value="${product.description}"/></td>
						<td><c:out value="${product.price}"/></td>
						<td><c:out value="${product.getCategories().size()}"/> categories</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h1>Categories</h1>
		<a href="/categories/new">Add a category</a>
		<table>
			<tr>
				<th>Category Name</th>
				<th>Product Count</th>
			</tr>
			<tbody>
				<c:forEach var="category" items="${categorieslist}">
					<tr>
						<td><a href ="/categories/<c:out value="${category.getId()}"/>"><c:out value="${category.name}"/></a></td>
						<td><c:out value="${category.getProducts().size()}"/> products</td>
					</tr>
				</c:forEach>
			</tbody>
	</body>
</html>