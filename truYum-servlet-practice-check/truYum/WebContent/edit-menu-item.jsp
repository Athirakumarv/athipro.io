<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Menu Item</title>
<style>
div.value {
	margin: 0 400px 0 400px;
}

h1 {
	margin: 100px 0 50px 400px;
}
</style>
<link rel="stylesheet" type="text/CSS" href="styles/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<h1>Edit Menu Item</h1>
	<div class="value">
		<div class="body-content-color">
			<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
				name="menuItemForm" method="post">
				<div class="form-field-spacing">
					<label for="name1">Name</label><br> <input type="text"
						value="${menuItem.name}" class="text-box text-box-title"
						name="name" id="name1" size="134">
				</div>
				<div class="form-field-spacing">
					<label for="price">Price(Rs.)</label><br> <input type="text"
						value="${menuItem.price}" class="text-box" name="price" id="price">
				</div>
				<div class="form-field-spacing">
					<label for="instock">Active</label><br> <input class="radio"
						type="radio" name="instock" id="instock" value="yes"
						<c:if test="${menuItem.active}">checked</c:if>>Yes <input
						class="radio" type="radio" id="instock" name="instock" value="no"
						<c:if test="${!menuItem.active}">checked</c:if>>No
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label><br> <input
						value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value='${menuItem.dateOfLaunch}' />"
						type="text" class="text-box" name="dateOfLaunch" id="">
				</div>
				<div class="form-field-spacing">
					<label for="category">Category</label><br> <select
						name="category" class="dropdown" id="">
						<option value="${menuItem.category}">${menuItem.category}</option>
						<option value="Starters">Starter</option>
						<option value="Main Course">Main Course</option>
						<option value="Dessert">Dessert</option>
						<option value="Drinks">Drinks</option>
					</select>
				</div>
				<br> <br>
				<div class="form-field-spacing">
					<label for=""></label> <input type="checkbox" name="freeDelivery"
						id="" <c:if test="${menuItem.freeDelivery}">checked</c:if>>Free
					Delivery
				</div>
				<br> <br>
				<div>
					<input type="hidden" name="id" value="${menuItem.id}">
				</div>
				<div>
					<input type="submit" class="button success-button" value="Save">
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>
