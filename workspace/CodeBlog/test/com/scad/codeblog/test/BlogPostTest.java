package com.scad.codeblog.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.scad.codeblog.blog.BlogPost;

public class BlogPostTest {
	
	private static final int TEST_BLOG_POST_ID = 1;
	private static final int TEST_BLOG_POST_AUTHOR_ID = 1;
	private static final Date TEST_BLOG_POST_DATE = new Date();
	private static final String TEST_BLOG_POST_HEADLINE = "TEST_BLOG_HEADLINE";
	private static final String TEST_BLOG_POST_BODY = "TEST_BLOG_POST_BODY";

	private BlogPost blogPost;
	
	@Before
	public void setUp() {
		this.blogPost = new BlogPost();
	}
	
	@Test
	public void instantiationTest() {
		assertNotNull(this.blogPost);
	}
	
	@Test
	public void setBlogIdTest() {
		this.blogPost.setBlogId(TEST_BLOG_POST_ID);
	}
	
	@Test
	public void setPostingDateTest() {
		this.blogPost.setPostingDate(TEST_BLOG_POST_DATE);
	}
	
	@Test
	public void setAuthorIdTest() {
		this.blogPost.setAuthorId(TEST_BLOG_POST_AUTHOR_ID);
	}
	
	@Test
	public void setHeadlineTest() {
		this.blogPost.setHeadline(TEST_BLOG_POST_HEADLINE);
	}
	
	@Test
	public void setBodyTest() {
		this.blogPost.setBody(TEST_BLOG_POST_BODY);
	}
	
	@Test
	public void getBlogIdTest() {
		this.blogPost.setBlogId(TEST_BLOG_POST_ID);
		assertEquals(TEST_BLOG_POST_ID, this.blogPost.getBlogId());
	}
	
	@Test
	public void getPostingDateTest() {
		this.blogPost.setPostingDate(TEST_BLOG_POST_DATE);
		assertEquals(TEST_BLOG_POST_DATE, this.blogPost.getPostingDate());
	}
	
	@Test
	public void getAuthorIdTest() {
		this.blogPost.setAuthorId(TEST_BLOG_POST_AUTHOR_ID);
		assertEquals(TEST_BLOG_POST_AUTHOR_ID, this.blogPost.getAuthorId());
	}
	
	@Test
	public void getHeadlineTest() {
		this.blogPost.setHeadline(TEST_BLOG_POST_HEADLINE);
		assertEquals(TEST_BLOG_POST_HEADLINE, this.blogPost.getHeadline());
	}
	
	@Test
	public void getBodyTest() {
		this.blogPost.setBody(TEST_BLOG_POST_BODY);
		assertEquals(TEST_BLOG_POST_BODY, this.blogPost.getBody());
	}
	
	@Test
	public void postTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void isPostedTest() {
		fail("Not yet implemented");
	}
	
	// TODO: add exceptional condition tests
	
	@After
	public void after() {
		this.blogPost = null;
	}

}
