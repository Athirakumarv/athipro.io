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
			<div class="home">truYum</div>
			<img src="images/truyum-logo-light.png">  <a href="ShowCart">Cart</a>
			<a href="ShowMenuItemListCustomer">Menu</a>
		</div>
		<div class="page-title">Products</div>
		<c:if test="${addCartStatus}">
			<div class="success-message">Item added to Cart Successfully</div>
		</c:if>
		<table class="body-content-colour">
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><c:if test="${menuItem.freeDelivery eq 'true'}">Yes</c:if>
						<c:if test="${menuItem.freeDelivery eq 'false'}">No</c:if></td>
					<td>Rs.<fmt:formatNumber type="number"
							pattern='##,##,##,###.00' value='${menuItem.price}' /></td>
					<td>${menuItem.category}</td>
					<td><a style="color: black" href="AddToCart?id=${menuItem.id}">Add
							to Cart</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
			<h3>Copyright @ 2019</h3>
		</div>
	</form>
</body>
</html>