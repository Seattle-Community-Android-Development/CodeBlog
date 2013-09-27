package com.helo478.codeblog.blog;

public class BlogFeed {

	private String bloggerName;

	private java.util.Collection<BlogPost> publishedBlogs;

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public java.util.Collection<BlogPost> getPublishedBlogs() {
		return publishedBlogs;
	}

	public void setPublishedBlogs(java.util.Collection<BlogPost> publishedBlogs) {
		this.publishedBlogs = publishedBlogs;
	}
}
