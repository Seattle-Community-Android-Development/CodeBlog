package com.helo478.codeblog.test;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helo478.codeblog.blog.BlogPost;
import com.helo478.codeblog.user.UserAccount;
import com.helo478.codeblog.user.UserManager;

public class HibernateTest {

	private final Date BLOG_POSTING_DATE = new Date();

	private static final String USER_NAME = "Test User Name";

	private static final byte[] USER_PASSWORD_HASH = null; // TODO: test with
															// password later

	private static final String BLOG_HEADLINE = "HEADLINE";

	private static final String BLOG_BODY = "This is the body of the test blog";

	private UserManager userManager;

	private UserAccount userAccount;

	private BlogPost blogPost;

	/**
	 * @param args
	 */
	public static void main(final String[] args) throws Exception {
		new HibernateTest().test();
	}

	private void test() throws Exception {
		setUpUserManager();
		setUpUserAccount();
		setUpBlogPost();
		publishBlogPost();
		persistUserAccount();
	}

	private void setUpUserManager() {

		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"springContext.xml");
		this.userManager = beanFactory.getBean(UserManager.class);
	}

	private void setUpUserAccount() throws Exception {
		this.userAccount = userManager
				.createUser(USER_NAME, USER_PASSWORD_HASH);
	}

	private void setUpBlogPost() {
		this.blogPost = new BlogPost();
		this.blogPost.setBody(BLOG_BODY);
		this.blogPost.setHeadline(BLOG_HEADLINE);
		this.blogPost.setPostingDate(BLOG_POSTING_DATE);
	}

	private void publishBlogPost() {
		this.userAccount.getPublishedBlogs().add(this.blogPost);
	}

	private void persistUserAccount() throws Exception {
		this.userManager.persistUser(userAccount);
	}
}
