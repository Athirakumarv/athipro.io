<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" type="text/CSS" href="styles/style.css">
</head>
<body>
	<form action="" method="get">
		<div class="topnav">
			<div class="home">Movie Cruiser</div>
			<a href="ShowFavorites">Favorites</a>
			<img src="images/fg.png"> <a href="ShowMoviesListCustomer">Movies</a>			
		</div>
		<div class="page-title">Movies</div>
		<c:if test="${addFavoritesStatus}">
			<div class="success-message">Movie added to Favorites Successfully</div>
		</c:if>
		<table class="body-content-colour">
			<tr>
				<th>Title</th>
				<th>Gross</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${moviesList}" var="movies">
				<tr>
					<td>${movies.title}</td>
					<td>$<fmt:formatNumber type="number"
							pattern='##,##,##,###' value='${movies.gross}' /></td>
					<td>${movies.genre}</td>
					<td><c:if test="${movies.teaser eq 'true'}">Yes</c:if>
						<c:if test="${movies.teaser eq 'false'}">No</c:if></td>	
					<td><a style="color: black" href="AddToFavorites?id=${movies.id}">Add
							to Favorites</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
			<p>Copyright @ 2019</p>
		</div>
	</form>
</body>
</html>