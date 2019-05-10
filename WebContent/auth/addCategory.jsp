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
	<form action="/SupCommerce/auth/addCategory" method="POST">
		<div class="form-group">
			<h3>New category</h3>
			name:<br> <input name="name" type="text" value="">
			<input type="submit" value="Submit">
		</div>
	</form>
</body>
</html>