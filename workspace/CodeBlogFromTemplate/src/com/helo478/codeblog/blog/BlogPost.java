package com.helo478.codeblog.blog;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class BlogPost {

	@Temporal(TemporalType.DATE)
	private Date postingDate;

	private String headline;

	private String body;

	public BlogPost() {
		super();
	}

	public Date getPostingDate() {
		return this.postingDate;
	}

	public void setPostingDate(final Date postingDate) {
		this.postingDate = postingDate;
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
