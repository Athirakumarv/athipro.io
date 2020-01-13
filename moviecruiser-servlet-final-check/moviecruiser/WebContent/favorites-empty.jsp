<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/style.css">
<script src="script.js"></script>
<title>Edit Movies</title>
<style>
h1 {
	margin: 50px 0 0 100px;
}

h4 {
	margin: 50px 0 0 100px;
}
</style>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/fg.png"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1>Favorites</h1>
	<h4 style="color: grey">
		No movies in favorites.Use add to favorites option in <a
			href="ShowMoviesListCustomer">Movies List</a>
	</h4>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>