package com.scad.codeblog.user;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.scad.codeblog.persistence.BlogDao;

public class UserManagerImpl implements UserManager {
	
	private static final Logger logger = Logger.getLogger(UserManagerImpl.class.getName());
	
	private BlogDao blogDao;
	
	public UserManagerImpl(final BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public UserAccount createUser(String userName, byte[] passwordHash)
			throws UserManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccount loginUser(String userName, byte[] passwordHash)
			throws UserManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(long userId) throws UserManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() throws UserManagerException {
		try {
			this.blogDao.reset();
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException("Unable to reset", ue);
		}
	}

	@Override
	public void close() throws UserManagerException {
		try {
			this.blogDao.close();
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException("Unable to close", ue);
		}
	}

}