package com.helo478.codeblog.user;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.helo478.codeblog.blog.BlogFeed;
import com.helo478.codeblog.persistence.BlogDao;

public class UserManagerImpl implements UserManager {

	private static final Logger logger = Logger.getLogger(UserManagerImpl.class
			.getName());

	private BlogDao blogDao;

	public UserManagerImpl(final BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public String toString() {
		return "The singleton, UserManagerImpl";
	}

	@Override
	public UserAccount createUser(final String userName,
			final byte[] passwordHash) throws UserManagerException {

		if (logger.isLoggable(Level.INFO)) {
			final StringBuffer enteringLog = new StringBuffer();
			enteringLog.append("Entering ");
			enteringLog.append(UserManagerImpl.class.getName());
			enteringLog
					.append(".createUser(String userName, byte[] passwordHash) for userName: ");
			enteringLog.append(userName);
			enteringLog.append(" and passwordHash: ");
			enteringLog.append(passwordHash);

			logger.info(enteringLog.toString());
		}

		try {
			UserAccount createdUser = new UserAccount(userName, passwordHash);
			createdUser.setUserManager(this);
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
			final byte[] passwordHash) throws UserManagerException,
			InvalidUserException, InvalidPasswordException {

		// TODO Add code to verify the password

		try {
			return this.blogDao.getUserByName(userName);
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);

			final StringBuffer sb = new StringBuffer();
			sb.append("Unable to loginUser for userName: ");
			sb.append(userName);

			throw new UserManagerException(sb.toString(), ue);
		}
	}

	@Override
	public void persistUser(final UserAccount userAccount)
			throws UserManagerException {

		try {

			blogDao.setUser(userAccount);

		} catch (UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);

			final StringBuffer sb = new StringBuffer();
			sb.append("Unable to persist userAccount: ");
			sb.append(userAccount.toString());

			throw new UserManagerException(sb.toString(), ue);
		}
	}

	@Override
	public boolean changePassword(final UserAccount userAccount,
			final byte[] oldPasswordHash, final byte[] newPasswordHash) {

		return new PasswordChanger(userAccount, oldPasswordHash,
				newPasswordHash).go();
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
	public List<String> getBloggersNamesList() throws UserManagerException {

		try {
			return this.blogDao.getBloggersNamesList();
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException(
					"Unable to get a list of all blogger's names", ue);
		}
	}

	@Override
	public void deleteUser(final int userId) throws UserManagerException {
		try {
			this.blogDao.deleteUser(userId);
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);
			throw new UserManagerException("Unable to delete user: "
					+ String.valueOf(userId), ue);
		}
	}

	@Override
	public BlogFeed getFeed(final String userName) throws UserManagerException,
			InvalidUserException {
		try {
			UserAccount user = blogDao.getUserByName(userName);
			BlogFeed blogFeed = new BlogFeed();
			blogFeed.setBloggerName(user.getUserName());
			blogFeed.setPublishedBlogs(user.getPublishedBlogs());
			return blogFeed;
		} catch (final UserException ue) {
			final String message = ue.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ue);

			final StringBuffer sb = new StringBuffer();
			sb.append("Unable to get BlogFeed for userName: ");
			sb.append(userName);
			throw new UserManagerException(sb.toString(), ue);
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
