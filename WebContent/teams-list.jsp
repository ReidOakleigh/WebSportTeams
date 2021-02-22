<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sports Teams</title>
</head>
<body>
  <form method="post" action="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allTeams}" var="currentteam" >
			<tr>
				<td><input type="radio" name="id" value="${currentteam.id}"></td>
				<td>${currentteam.city}</td>
				<td>${currentteam.name}</td>
				<td>${currentteam.sport}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="edit"   name="doThisToTeam">
	<input type="submit" value="delete" name="doThisToTeam">
	<input type="submit" value="add"    name="doThisToTeam">
  </form>
</body>
</html>