package com.scad.codeblog.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.scad.codeblog.persistence.BlogDao;
import com.scad.codeblog.persistence.BlogDaoFactory;
import com.scad.codeblog.persistence.BlogDaoFactoryException;
import com.scad.codeblog.user.UserAccount;
import com.scad.codeblog.user.UserException;
import com.scad.codeblog.user.UserManagerFactory;

public class BlogDaoTest {

	private static final int TEST_USER_ID = 1;
	private static final String TEST_USER_NAME = "TEST_USER_NAME";

	private BlogDao blogDao;
	private UserAccount user;

	@Before
	public void setUp() throws BlogDaoFactoryException {
		setUpDao();
		setUpUser();
	}

	private void setUpUser() {
		this.user = new UserAccount();
		this.user.setUserId(TEST_USER_ID);
		this.user.setUserName(TEST_USER_NAME);
	}

	private void setUpDao() throws BlogDaoFactoryException {

		BeanFactory beanFactory = new FileSystemXmlApplicationContext(
				"context.xml");

		BlogDaoFactory blogDaoFactory = beanFactory.getBean("BlogDaoFactory",
				BlogDaoFactory.class);

		if (blogDaoFactory == null) {
			throw new BlogDaoFactoryException(
					"Unable to create blog dao factory!");
		}

		this.blogDao = blogDaoFactory.getBlogDao();
	}

	@Test
	public void daoInstantiationTest() {
		assertNotNull(this.blogDao);
	}

	@Test
	public void userInstantiationTest() {
		assertNotNull(this.user);
	}

	@Test
	public void setUserTest() throws UserException {
		this.blogDao.setUser(this.user);

		// TODO: find a way to assert that there is more than zero rows in the
		// database
	}

	@Test
	public void getUserTest() throws UserException {
		final UserAccount retrievedUser = this.blogDao.getUser(TEST_USER_NAME);
		
		assertNotNull(retrievedUser);
		
		assertEquals(TEST_USER_NAME, retrievedUser.getUserName());
	}

	@After
	public void tearDown() throws UserException {
		this.blogDao.close();
		this.blogDao = null;
		this.user = null;
	}
}