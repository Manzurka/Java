<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New License </title>
	</head>
	<body>
		<h2>New License</h2>
		<form:form action="/addlicense" method ="post" modelAttribute="license">
			<form:label path="person"> Person:
			<form:select path="person">
						<c:forEach var="person" items="${list}">
							<c:if test="${person.getLicense() == null}">
								<form:option value="${person}" label="${person.getFullName()}"/>
							</c:if>
						</c:forEach>
			   		<form:options items="${list}"/>
			</form:select>
			</form:label>
			
			<form:label path="state"> State:
			<form:errors path="state"/>
			<form:input path="state"/></form:label>
			
			<form:label path="expiration_date"> Expiration Date:
			<form:errors path="expiration_date"/>
			<form:input  path="expiration_date"/></form:label>
			
			<form:label path="number">
			<form:hidden value="${number}" path="number"/></form:label>
			
			<input type="submit" value="Create"/>
		</form:form>
	</body>
</html>