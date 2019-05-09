<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.mds.supcommerce.dao.*"%>
<%@ page import="fr.mds.supcommerce.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
	<form action="/SupCommerce/auth/addProduct" method="POST">
		<div class="form-group">
			<h3>New product</h3>
			name:<br> <input name="name" type="text" value=""><br>
			description:<br> <input name="description" type="text" value=""><br>
			price:<br> <input name="price" type="number" value=""><br>
			<input type="submit" value="Submit">
		</div>
	</form>


</body>
</html>