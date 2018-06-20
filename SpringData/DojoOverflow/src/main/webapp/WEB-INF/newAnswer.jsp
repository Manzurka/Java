<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Answer</title>
	</head>
	<body>
		<h3><c:out value="${question.getQuestion()}"/></h3>
		<p>Tags:
		<c:forEach var="tag" items="${question.getTags()}">
			<c:out value="${tag.getSubject()}"/>,
		</c:forEach></p>
		
		<table>
			<tr>
				<th>Answers</th>
			</tr>
			<c:forEach var="answer" items="${question.getAnswers()}">
				<tr><td><c:out value="${answer.answer}"/></td></tr>
			</c:forEach>
		</table>
		<h3>Add your answer:</h3>
		<form:form action='/answers/create' method="post" modelAttribute="a">
			<form:label path="answer"> Add your answer:
			<form:errors path="answer"/>
			<form:textarea path="answer"/></form:label>
			<input type="hidden" name="id" value='<c:out value="${question.getId()}"/>'/>
			<input type="submit" value="Answer it!"/>
		</form:form>
	</body>
</html>