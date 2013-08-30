package com.scad.codeblog.user;

import java.util.logging.Logger;

import com.scad.codeblog.persistence.BlogDao;

/**
 * The Class UserManagerFactoryImpl.
 * 
 * @author Donald Subert
 */
public class UserManagerFactoryImpl implements UserManagerFactory {
	
	private static final Logger logger = Logger.getLogger(UserManagerFactoryImpl.class.getName());
	
	/**
	 * Instantiates an implementation of UserManagerFactory
	 */
	public UserManagerFactoryImpl() {
		super();
	}

	@Override
	public UserManager getUserManager(final BlogDao blogDao) {
		
		logger.entering(UserManagerFactoryImpl.class.getName(), "getUserManager");
		
		return new UserManagerImpl(blogDao);
	}

}
