package com.scad.codeblog.persistence;

import com.scad.codeblog.user.UserAccount;
import com.scad.codeblog.user.UserException;

/**
 * Defines the public methods of a blog dao.
 *
 * @author Donald Subert
 */
public interface BlogDao {

	/**
	 * Gets the user for a given user id.
	 *
	 * @param userName the user name
	 * @return the user for the given user id
	 * @throws UserException the user exception
	 */
	UserAccount getUser(String userName) throws UserException;
	
	/**
	 * Persists a user.
	 *
	 * @param user the new user
	 * @throws UserException the user exception
	 */
	void setUser(UserAccount user) throws UserException;
	
	/**
	 * Rename the given user to the given user name.
	 *
	 * @param user the user
	 * @param newUserName the new user name
	 * @throws UserException the user exception
	 */
	void renameUser(UserAccount user, String newUserName) throws UserException;
	
	/**
	 * Delete the user for a given user id.
	 *
	 * @param userId the user id
	 * @throws UserException the user exception
	 */
	void deleteUser(long userId) throws UserException;
	
	/**
	 * Deletes all users.
	 *
	 * @throws UserException the user exception
	 */
	void reset() throws UserException;
	
	/**
	 * Close connection to the persistent data. This will cause an exception if methods are called afterward.
	 *
	 * @throws UserException the user exception
	 */
	void close() throws UserException;
}
