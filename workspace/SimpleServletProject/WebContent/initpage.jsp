<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Init Page</title>
</head>
<body>

	<%!public void jspInit() {

		String defaultUser = getServletConfig().getInitParameter("defaultUser");
		ServletContext context = getServletContext();
		context.setAttribute("defaultUser", defaultUser);

	}%>

	<h3>
		The default user is:
		<%=getServletConfig().getInitParameter("defaultUser")%></h3>

	<br>

	<h3>
		The value in the Servelet Context is:
		<%=getServletContext().getAttribute("defaultUser")%></h3>

	<br> The difference between the ServletConfig and the
	ServletContext is this: Config should be used to pass immutable
	parameters, while Context should store dynamic variables.

</body>
</html>