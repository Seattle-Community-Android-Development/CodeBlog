package com.scad.codeblog.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
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
	private static final Logger logger = Logger
			.getLogger(BlogDaoHibernateImpl.class.getName());

	/**
	 * Instantiates a new Hibernate3 implementation of BlogDao
	 * 
	 * @throws UserException
	 *             , indicating a problem instantiating the object
	 */
	public BlogDaoHibernateImpl() {
		this.sessionFactory = new Configuration().configure()
				.buildSessionFactory();
	}

	/*@Override
	public int getUserAccountPrimaryKey(final String userName) {

		logger.entering(BlogDaoHibernateImpl.class.getName(),
				"getUserAccountPrimaryKey()");

		checkInvariants();

		// TODO: implement

		return -1;
	}*/

	private int getUserId(final UserAccount userAccount) {
		return userAccount.getUserId();
	}
	
	public UserAccount getUser(final String username) {
		
		logger.entering(BlogDaoHibernateImpl.class.getName(), "getUser(String)");
		
		checkInvariants();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT userid FROM useraccount WHERE accountname = '" + username + "'");
		// TODO: execute query
		
		return null;
	}

	@Override
	public UserAccount getUser(final int userId) throws UserException {

		logger.entering(BlogDaoHibernateImpl.class.getName(), "getUser()");

		checkInvariants();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserAccount retrievedUser = (UserAccount) session.get(
				UserAccount.class, userId);

		if (retrievedUser == null) {
			throw new UserException("Unable to get user for userId: " + userId);
		}

		return retrievedUser;
	}

	@Override
	public void setUser(final UserAccount user) throws UserException {

		logger.entering(BlogDaoHibernateImpl.class.getName(), "setUser()");

		checkInvariants();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();

		// TODO: figure out how to handle the hibernate exception and redirect
		// it as a userException
	}

	@Override
	public void renameUser(final UserAccount user, final String newUserName) {

		logger.entering(BlogDaoHibernateImpl.class.getName(), "renameUser()");

		checkInvariants();

		// TODO: Implement
	}

	@Override
	public void deleteUser(final int userId) throws UserException {

		logger.entering(BlogDaoHibernateImpl.class.getName(), "deleteUser()");

		try {
			checkInvariants();
		} catch (IllegalStateException ise) {
			final String message = ise.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ise);
			throw new UserException("Unable to delete user for id: " + userId, ise);
		}

		final UserAccount userToDelete = this.getUser(userId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(userToDelete);
		session.getTransaction().commit();

		// TODO: wrap the hibernate exception in a user exception
	}

	@Override
	public void reset() throws UserException {

		logger.entering(BlogDaoHibernateImpl.class.getName(), "reset()");

		checkInvariants();

		// TODO Implement
	}

	@Override
	public void close() throws UserException {

		logger.entering(BlogDaoHibernateImpl.class.getName(), "close()");

		try {
			checkInvariants();
		} catch (final IllegalStateException ise) {
			final String message = ise.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ise);
			throw new UserException("Unable to close data connection", ise);
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.disconnect();

		sessionFactory = null;
	}

	/**
	 * Checks that state variables have been initialized and not closed.
	 */
	private void checkInvariants() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			throw new IllegalStateException(String.format(
					"A field has not been initialized, or the data connection has been closed."
							+ "sessionFactory == %s", sessionFactory));
		}
	}

	@Override
	public int getUserAccountPrimaryKey(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
