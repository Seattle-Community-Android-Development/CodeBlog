package com.helo478.codeblog.test;

import com.helo478.codeblog.persistence.BlogDao;
import com.helo478.codeblog.persistence.BlogDaoHibernateImpl;

public class BlogDaoAppTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlogDao blogDao = new BlogDaoHibernateImpl();
	}

}
