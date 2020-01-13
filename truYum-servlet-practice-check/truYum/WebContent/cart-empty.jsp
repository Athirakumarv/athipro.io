<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Edit Menu Item</title>
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
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> 		
		<a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<h1>Cart</h1>
	<h4 style="color: grey">
		No items in cart.Use add to cart option in <a
			href="ShowMenuItemListCustomer">Menu Item List</a>
	</h4>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>