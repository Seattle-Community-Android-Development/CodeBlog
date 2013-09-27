package com.helo478.codeblog.user;

/**
 * The Class UserManagerException.
 */
public class UserManagerException extends Exception {

	/**
	 * Version Id.
	 */
	private static final long serialVersionUID = 9016898207501572966L;

	/**
	 * Instantiates a new user manager exception.
	 */
	public UserManagerException() {
		super();
	}
	
	/**
	 * Instantiates a new user manager exception.
	 *
	 * @param message the message describing the exception condition
	 */
	public UserManagerException(final String message) {
		super(message);
	}
	
	/**
	 * Instantiates a new user manager exception.
	 *
	 * @param message the message describing the exception condition
	 * @param cause the exception causing this exception
	 */
	public UserManagerException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Instantiates a new user manager exception.
	 *
	 * @param cause the exception causing this exception
	 */
	public UserManagerException(final Throwable cause) {
		super(cause);
	}
}
