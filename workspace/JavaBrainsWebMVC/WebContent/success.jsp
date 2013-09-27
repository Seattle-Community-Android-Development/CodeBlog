<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.javabrains.webmvc.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>

	<%
		// This is from the client-side redirect version of redirect
		// * User user = (User) session.getAttribute("user");
	
		// This is the server-side implementation of redirect
		User user = (User) request.getAttribute("user");
	%>

	<h3>
		Logged in as:
		<%=user.getUserName()%></h3>

</body>
</html>