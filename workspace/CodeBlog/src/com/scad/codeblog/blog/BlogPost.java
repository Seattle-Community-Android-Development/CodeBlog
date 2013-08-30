package com.scad.codeblog.blog;

import java.util.Date;

public class BlogPost {

	private int blogId;

	private Date postingDate;

	private int authorId;

	private String headline;

	private String body;

	/** A no-argument constructor for JPA/Hibernate only
	 * 
	 */
	public BlogPost() {
		super();
	}
	
	public BlogPost(final int authorId, final String headline, final String body) {
		this.authorId = authorId;
		this.headline = headline;
		this.body = body;
		
		// TODO: figure out how to set blogId
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(final int id) {
		this.blogId = id;
	}

	public Date getPostingDate() {
		return this.postingDate;
	}

	public void setPostingDate(final Date postingDate) {
		this.postingDate = postingDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(final int authorId) {
		this.authorId = authorId;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(final String heading) {
		this.headline = heading;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}
	
	public void post() {
		this.postingDate = new Date();
	}

	public boolean isPosted() {
		return this.postingDate != null;
	}
}
