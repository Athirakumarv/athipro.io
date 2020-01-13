<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<script src="script.js"></script>
<title>Edit Menu Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="page-title">Cart</div>
	<c:if test="${deleteCartStatus}">
		<div class="success-message">Item removed from the cart
			successfully</div>
	</c:if>
	<!--         <h1>Cart</h1> -->
	<table cellpadding="20px">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
		</tr>
		<tr>
			<c:forEach items="${cart.menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name }</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td>Rs.<fmt:formatNumber value="${menuItem.price}"
							pattern="#,##,##,##,###.00" />
					</td>
					<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
			</c:forEach>
		</tr>
		<tr>
			<td></td>
			<td><b>Total</b></td>
			<td>Rs.<fmt:formatNumber value="${cart.total}"
					pattern="#,##,##,##,###.00" />
			</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">Copyright @2019</div>
</body>
</html>




















