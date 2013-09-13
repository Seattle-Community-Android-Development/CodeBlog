package com.scad.codeblog.user;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.scad.codeblog.persistence.BlogDao;

public class UserManagerImpl implements UserManager {

	private static final Logger logger = Logger.getLogger(UserManagerImpl.class
			.getName());

	private BlogDao blogDao;

	public UserManagerImpl(final BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public UserAccount createUser(final String userName,
			final byte[] passwordHash) throws UserManagerException {

		try {
			UserAccount createdUser = new UserAccount(userName, passwordHash);
			this.blogDao.setUser(createdUser);
			return createdUser;
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException(
					"Unable to create user: " + userName, ue);
		}
	}

	@Override
	public UserAccount loginUser(final String userName,
			final byte[] passwordHash) throws UserManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePassword(final UserAccount userAccount,
			final byte[] oldPasswordHash, final byte[] newPasswordHash) {

		return new PasswordChanger(userAccount, oldPasswordHash, newPasswordHash).go();
	}

	private class PasswordChanger {

		private UserAccount userAccount;
		private byte[] oldPasswordHash;
		private byte[] newPasswordHash;

		private PasswordChanger(final UserAccount userAccount,
				final byte[] oldPasswordHash, final byte[] newPasswordHash) {
			this.userAccount = userAccount;
			this.oldPasswordHash = oldPasswordHash;
			this.newPasswordHash = newPasswordHash;
		}

		private boolean go() {

			if (verifyPassword()) {

				try {
					updateAccountPassword();
					persistAccount();
				} catch (final UserException ue) {
					final String message = "Unable to change password for account: "
							+ userAccount.getUserName()
							+ "\n"
							+ ue.getMessage();
					logger.log(Level.WARNING, message, ue);
					
					revertToOldPassword();
					
					return false;
				}
				
				return true;

			} else {
				return false;
			}
		}
		
		private boolean verifyPassword() {
			return (userAccount.getPasswordHash().equals(oldPasswordHash));
		}

		private void updateAccountPassword() {
			userAccount.setPasswordHash(newPasswordHash);
		}

		private void persistAccount() throws UserException {
			blogDao.setUser(userAccount);
		}

		private void revertToOldPassword() {
			userAccount.setPasswordHash(oldPasswordHash);
		}
	}

	@Override
	public void deleteUser(final int userId) throws UserManagerException {
		try {
			this.blogDao.deleteUser(userId);
		} catch (UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException("Unable to delete user: "
					+ String.valueOf(userId), ue);
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
