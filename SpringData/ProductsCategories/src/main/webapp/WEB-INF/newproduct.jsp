<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Product</title>
		<style> 
			ul li {
			list-style-type:none;
			}
		</style>
	</head>
	<body>
		<h1>New Product</h1>
		<ul>
			<form:form action="/products/create" method="post" modelAttribute="product">
				<form:label path="name">Name:
				<form:errors path="name"/>
				<form:input path="name"/></form:label>
				<li><form:label path="description">Description: 
					<form:errors path="description"/></li>
				<li><form:textarea path="description"/></form:label></li>
				<li><form:label path="price">Price:
				<form:errors path="price"/></li>
				<li><form:input path="price"/></form:label></li>
				<li><input type="submit" value="Create"/></li>
			</form:form>
		</ul>
	</body>
</html>