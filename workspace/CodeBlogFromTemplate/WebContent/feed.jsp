<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.helo478.codeblog.blog.BlogPost, java.util.List, 
	com.helo478.codeblog.blog.BlogFeed, 
	com.helo478.codeblog.util.ServletConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feed</title>
</head>
<body>
	<%
		final String bloggerName = request.getParameter(ServletConstants.PARAMETER_BLOGGER_NAME);
		final BlogFeed bloggerFeed = userManager.getFeed(bloggerName);

		final java.util.Collection<BlogPost> publishedBlogs = bloggerFeed
				.getPublishedBlogs();
	%>


	<h1><%=bloggerName%></h1>
	<%
		final StringBuffer sb = new StringBuffer();

		for (BlogPost post : publishedBlogs) {
	%>

	<h5><%=post.getPostingDate()%></h5>
	<h3><%=post.getHeadline()%></h3>
	<p><%=post.getBody()%></p>


	<%
		}
	%>

</body>
</html>