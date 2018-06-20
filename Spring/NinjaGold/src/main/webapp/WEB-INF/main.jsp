<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<style type="text/css">
        	<%@include file="css/style.css" %>
        </style>
	</head>
	<body>
		<h3>Your gold: <c:out value ="${gold}"/></h3>
        <div id="farm">
            <h1>Farm</h1>
            <h2>Earns 10-20 golds</h2>
            <form action="/check" method="post">
                <input type="hidden" name="building" value="farm" />
                <input type="submit" value="Find Gold!"/>
              </form>
        </div>
        <div id ="cave">
            <h1>Cave</h1>
            <h2>Earns 5-10 golds</h2>
            <form action="/check" method="post">
                <input type="hidden" name="building" value="cave" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div id="house">
            <h1>House</h1>
            <h2>Earns 2 - 5 golds</h2>
            <form action="/check" method="post">
                <input type="hidden" name="building" value="house" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div id="casino">
            <h1>Casino</h1>
            <h2>Earns/takes 0-50 golds</h2>
            <form action="/check" method="post">
                <input type="hidden" name="building" value="casino" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <h3>Activities</h3>
        <div id="activity">
            <c:forEach var="act" items="${activity}">
            	<p><c:out value ="${act}"/></p>
            </c:forEach>
        </div>
	</body>
</html>