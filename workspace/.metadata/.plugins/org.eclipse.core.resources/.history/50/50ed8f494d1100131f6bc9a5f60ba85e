package com.scad.codeblog.persistence;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.scad.codeblog.user.UserAccount;
import com.scad.codeblog.user.UserException;

/**
 * An implementation of BlogDao using the Hibernate3 framework
 */
public class BlogDaoHibernateImpl implements BlogDao {
	
	private SessionFactory sessionFactory;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(BlogDaoHibernateImpl.class.getName());
	
	/**
	 * Instantiates a new Hibernate3 implementation of BlogDao
	 *
	 * @throws UserException, indicating a problem instantiating the object
	 */
	public BlogDaoHibernateImpl() throws UserException {
		super();
		
		// TODO: see if this really needs to throw that exception
		
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	@Override
	public UserAccount getUser(final String userName) throws UserException {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "getUser()");
		
		// TODO Implement
		return null;
	}

	@Override
	public void setUser(final UserAccount user) throws UserException {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "setUser()");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Override
	public void renameUser(final UserAccount user, final String newUserName) {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "renameUser()");
		
		// TODO: Implement
	}

	@Override
	public void deleteUser(final long userId) throws UserException {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "deleteUser()");
		// TODO Implement

	}

	@Override
	public void reset() throws UserException {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "reset()");
		// TODO Implement

	}

	@Override
	public void close() throws UserException {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "close()");
		// TODO Implement

	}
}
