package com.scad.codeblog.user;

/**
 * The Interface UserManager.
 * 
 * @author Donald Subert
 */
public interface UserManager {

	/**
	 * Creates the user.
	 * 
	 * @param userName
	 *            the user name
	 * @param passwordHash
	 *            the password hash
	 * @return the user account
	 * @throws UserManagerException
	 *             the user manager exception
	 */
	UserAccount createUser(String userName, byte[] passwordHash)
			throws UserManagerException;

	/**
	 * Login user.
	 * 
	 * @param userName
	 *            the user name
	 * @param passwordHash
	 *            the password hash
	 * @return the user account
	 * @throws UserManagerException
	 *             the user manager exception
	 */
	UserAccount loginUser(String userName, byte[] passwordHash)
			throws UserManagerException;

	/**
	 * Change password.
	 * 
	 * @param userAccount
	 *            the user account whose password is to change
	 * @param newPasswordHash
	 *            the new password hash
	 * @return true, if successful
	 */
	boolean changePassword(UserAccount userAccount, byte[] oldPasswordHash,
			byte[] newPasswordHash);

	/**
	 * Delete user.
	 * 
	 * @param userId
	 *            the user id
	 * @throws UserManagerException
	 *             the user manager exception
	 */
	void deleteUser(int userId) throws UserManagerException;

	/**
	 * Reset.
	 * 
	 * @throws UserManagerException
	 *             the user manager exception
	 */
	void reset() throws UserManagerException;

	/**
	 * Close.
	 * 
	 * @throws UserManagerException
	 *             the user manager exception
	 */
	void close() throws UserManagerException;

}
