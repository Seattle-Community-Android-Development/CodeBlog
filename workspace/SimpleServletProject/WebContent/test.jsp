<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello World!</h3>

	<%!public int add(int a, int b) {
		return a + b;
	}%>

	<%
		int i = 1;
		int j = 2;
		int k;

		k = add(i, j);

		out.println("Value of k is " + String.valueOf(k));
	%>

	<p>
		The value of k + 1 is
		<%=1 + k%>
	</p>

	<p>
		<%
			for (int t = 0; t < 10; t++) {
				out.println("<br>value of t is " + String.valueOf(t));
			}
		%>
	</p>
	
		<p>
		<%
			for (int u = 0; u < 10; u++) {
		%>
		
		<br> The value of u is <%=u %>
		
		<% } %>
	</p>
</body>
</html>