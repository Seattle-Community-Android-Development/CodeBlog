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
		
		try {
			UserAccount createdUser = new UserAccount(userName);
			this.blogDao.setUser(createdUser);
			return createdUser;
		} catch(final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException("Unable to create user: " + userName, ue);
		}
	}

	@Override
	public UserAccount loginUser(String userName, byte[] passwordHash)
			throws UserManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) throws UserManagerException {
		try {
			this.blogDao.deleteUser(userId);
		} catch (UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException("Unable to delete user: " + String.valueOf(userId), ue);
		}
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
