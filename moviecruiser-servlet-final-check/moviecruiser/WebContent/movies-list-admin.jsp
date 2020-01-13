<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Items</title>
<link rel="stylesheet" type="text/CSS" href="styles/style.css">
</head>
<body>
	<form action="ShowMoviesListAdmin" method="get">
		<div class="topnav">
			<div class="home">Movie Cruiser</div>
			<img src="images/fg.png"> <a href="ShowMoviesListAdmin">Movies</a>
		</div>
		<div class="page-title">Movies</div>
		<table class="body-content-colour">
			<tr>
				<th>Title</th>
				<th>Gross</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${moviesList}" var="movies">
				<tr>
					<td>${movies.title}</td>
					<td>$.<fmt:formatNumber type="number"
							pattern='##,##,##,###' value='${movies.gross}' /></td>
					<td><c:if test="${movies.active eq 'true'}">Yes</c:if> <c:if
							test="${movies.active eq 'false'}">No</c:if></td>
					<td><fmt:formatDate type="date" pattern='dd/MM/yyyy'
							value='${movies.dateOfLaunch}' /></td>
					<td>${movies.genre}</td>
					<td><c:if test="${movies.teaser eq 'true'}">Yes</c:if> <c:if
							test="${movies.teaser eq 'false'}">No</c:if></td>
					<td><a style="color: black"
						href="ShowEditMovies?id=${movies.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
			<p>Copyright @ 2019</p>
		</div>
	</form>
</body>
</html>