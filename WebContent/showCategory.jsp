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
<%@ include file="/header.jsp" %>
<h1>Show category</h1>
	<%
		System.out.println("ShowCategoryServlet - doGet : req.getParameter(\"id\") " + request.getParameter("id"));

		Long id = 0L;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException e) {
			out.println("Error " + e);
			return;
		}

		//TODO afficher les category

	%>
</body>
</html>