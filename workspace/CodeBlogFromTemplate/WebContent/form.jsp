<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>

	<%@include file="navigationBar.jsp"%>

	<br>
	<form action="review.jsp" method="post">
		<div align="center">
			<p>Enter blog content here:</p>
			<textarea name="blogPost" cols="50" rows="20"></textarea>
			<input type="submit" />
		</div>
	</form>

	<br>

</body>

</html>