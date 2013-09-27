<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.helo478.codeblog.util.ServletConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="CreateAccountServlet" method="post">
		<br>User ID: <input type="text"
			name=<%= ServletConstants.ATTRIBUTE_USER_NAME %> /> <br>Password: <input
			type="password" name=<%= ServletConstants.ATTRIBUTE_PASSWORD %>/> <br> <br>
		<input type="submit" />
	</form>
</body>
</html>