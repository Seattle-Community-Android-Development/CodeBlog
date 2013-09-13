package com.scad.codeblog.user;

/**
 * An Exception indicating a problem sending or retrieving data to/from the BlogDao
 */
public class UserException extends Exception {

	/**
	 * Version id.
	 */
	private static final long serialVersionUID = 3973862777245896585L;

	/**
	 * Instantiates a new user exception.
	 */
	public UserException() {
		super();
	}
	
	/**
	 * Instantiates a new user exception.
	 *
	 * @param message the message describing the exception condition
	 */
	public UserException(final String message) {
		super(message);
	}
	
	/**
	 * Instantiates a new user exception.
	 *
	 * @param message the message describing the exception condition
	 * @param cause the exception causing this exception
	 */
	public UserException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Instantiates a new user exception.
	 *
	 * @param cause the exception causing this exception
	 */
	public UserException(final Throwable cause) {
		super(cause);
	}
}
