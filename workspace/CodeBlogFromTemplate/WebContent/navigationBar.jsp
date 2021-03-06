<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.helo478.codeblog.util.ServletConstants, com.helo478.codeblog.util.WebConstants" %>

<%!private UserAccount activeUser = null;%>

<%!public boolean isLoggedIn() {
		return activeUser != null;
	}%>

<%!public void logOut() {
		this.activeUser = null;
	}%>

<%
	// With each request, checks the session for an active user account and set's it as a servlet instance variable
	this.activeUser = (UserAccount) request.getSession().getAttribute(
			ServletConstants.ATTRIBUTE_ACTIVE_USER);
%>

<table border="1" width="100%">
	<tr>
		<td><h5>
				<a href="">CodeBlog</a>
			</h5></td>
		<td>
			<% if (isLoggedIn()) { %>
				<p>logged in as <a href="accountManagement.jsp"><%= activeUser.getUserName() %></a></p>
			<% } %>
		</td>
		<td>
			<% if (isLoggedIn()) {	%>
				<p><a href="/LogoutServlet">logout</a></p> 
			<% } else { %>
				<p><a href="login.jsp">login</a> / <a href="createAccount.jsp">create account</a></p>
			<% } %>
		</td>
	</tr>
</table>