package com.helo478.codeblog.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helo478.codeblog.user.UserManager;

public class ResetPersistedData {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		final BeanFactory beanFactory = new ClassPathXmlApplicationContext("springContext.xml");
		final UserManager userManager = beanFactory.getBean(UserManager.class);
		userManager.reset();
	}

}
