package com.scad.codeblog.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.scad.codeblog.user.UserException;

/**
 * A factory for creating BlogDaoHibernateImpl objects.
 * 
 * @author Donald Subert
 */
public class BlogDaoHibernateFactoryImpl implements BlogDaoFactory {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(BlogDaoHibernateFactoryImpl.class.getName());

	/**
	 * Instantiates a new blog dao hibernate impl factory.
	 */
	public BlogDaoHibernateFactoryImpl() {
		super();
	}

	@Override
	public BlogDao getBlogDao() throws BlogDaoFactoryException {
		
		logger.entering(BlogDaoHibernateFactoryImpl.class.getName(), "getBlogDao()");
		
		//try {
			return new BlogDaoHibernateImpl();
		//} catch (final UserException ue) {
		//	final String message = ue.getMessage();
		//	logger.log(Level.WARNING, message != null ? message : "", ue);
		//	throw new BlogDaoFactoryException("Unable to instantiate a new BlogDaoHibernateImpl", ue);
		//}
	}
}