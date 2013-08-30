package com.helo478.hibernatepostgresql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		com.scad.codeblog.user.UserAccount user = new com.scad.codeblog.user.UserAccount();
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
