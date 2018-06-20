<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ideas</title>
		<style type="text/css">
        	<%@include file="static/css/style.css" %>
        </style>
	</head>
	<body>
		<form id="logoutForm" method="POST" action="/logout" class="logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" />
	    </form>
		
		<h1>Welcome ${currentUser.name}!</h1>
		
		<h3>Ideas</h3>
		<div class="sort">
			<a href="/ideas/sortByLowLikes">Low Likes</a>
			<a href="/ideas/sortByHighLikes">High Likes</a>
		</div>
		<table>
				<tr>
					<th>Idea</th>
					<th>Created By</th>
					<th>Likes</th>
					<th>Action</th>
				</tr>
				<tbody>
					<c:if test="${ideas !=null}">
					<c:forEach var="idea" items="${ideas}">
					<tr>
						<td><a href="/ideas/${idea.id}">${idea.name}</a></td>
						<td>${idea.creator.name}</td>
						<td>${idea.likedUsers.size()}</td>
						<td>
							 <c:if test="${!idea.likedUsers.contains(currentUser)}">
							 	<a href="/ideas/${idea.id}/like">Like</a>
							 </c:if>
							 <c:if test ="${idea.likedUsers.contains(currentUser)}">
							 	<a href="/ideas/${idea.id}/unlike">Unlike</a>
							 </c:if>
						 </td>
					</tr>
					</c:forEach>
					</c:if>
				
				</tbody>
			</table>
			<br>
			<a href="/ideas/new"><button>Create an idea</button></a>
	</body>
</html>