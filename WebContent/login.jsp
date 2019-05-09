<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<form method="post" action="login">

<input type="email" name="email" id="email" value="email@gmail.com"/>
  
<input type="password" name="password" id="password" value="password" />
  

<button type="submit" type="button">Login</button>

 
</form>
</body>
</html>