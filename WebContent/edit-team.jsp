<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sports Teams</title>
</head>
<body>
	<form action="editTeamServlet" method="post">
		City: <input type="text" name="city" value="${teamToEdit.city}">
		Name: <input type="text" name="name" value="${teamToEdit.name}">
		Sport: <input type="text" name="sport" value="${teamToEdit.sport}">
		<input type="hidden" name="id" value="${teamToEdit.id}">
		<input type="submit" value="Save Edited Team">
	</form>
</body>
</html>