<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		final String requestUserName = request.getParameter("userName");
	
	
		if (requestUserName != null) {
			session.setAttribute("userName", requestUserName);
			//application.setAttribute("userName", requestUserName);
			pageContext.setAttribute("userName", requestUserName);
			pageContext.setAttribute("userName", requestUserName, PageContext.APPLICATION_SCOPE);
		}
	
		final String sessionUserName = (String) session.getAttribute("userName");
		final String applicationUserName = (String) application.getAttribute("userName");
		final String pageContextUserName = (String) pageContext.getAttribute("userName");
		final String findAttributeUserName = (String) pageContext.findAttribute("userName");
	%>

	<p>
		The user name in the request object is
		<%=requestUserName%>
	</p>
	<p>
		The user name in the session object is 
		<%=sessionUserName %>
	<p>
		The user name in the application object is
		<%=applicationUserName %>
	</p>
	<p>
		The user name in the page context object is 
		<%=pageContextUserName %>
	</p>
	<p>
		The user name returned by findAttribute("userName") is 
		<%=findAttributeUserName %>
	
</body>
</html>