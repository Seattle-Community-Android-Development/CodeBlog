package com.scad.codeblog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.scad.codeblog.user.UserAccount;

public class HibernateTestApp {

	public static void main(String[] args) {
		UserAccount user = new UserAccount();
		user.setUserId(1);
		user.setUserName("First User");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
}