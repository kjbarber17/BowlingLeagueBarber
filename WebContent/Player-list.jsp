<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Players</title>
</head>
<body>
<h1> List of Players</h1>
<form method = "post" action = "editPlayerServlet">
<table>
<c:forEach items = "${requestScope.allPlayers}" var="currentPlayer">
<tr>
	<td><input type="radio" name="id" value="${currentPlayer.playerId}">${currentPlayer.playerId}</td>
	<td>${currentPlayer.firstName}</td>
	<td>${currentPlayer.lastName}</td>
	<td>${currentPlayer.phoneNumber}</td>
	<td>${currentPlayer.screenName}</td>
	<td>${currentPlayer.team.getTeamName()}
	</tr>
	</c:forEach>
	</table>
	<br />
	<input type = "submit"value = "Delete Selected Player" name="doThisToPlayer">
	<br />
	<input type = "submit"value = "Add New Player" name="doThisToPlayer">
	</form>
	<a href = "index.html"> Back to Menu</a><br/>
</body>
</html>