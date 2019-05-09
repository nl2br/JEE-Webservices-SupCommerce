<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="fr.mds.supcommerce.dao.*"%>
<%@ page import="fr.mds.supcommerce.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List product</title>
</head>
<body>

<%@ include file="/header.jsp" %>

	<table>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>Nom : <c:out value="${p.name}" /></td>
				<td>Description : <c:out value="${p.description}" /></td>
				<td>Prix : <c:out value="${p.price}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>