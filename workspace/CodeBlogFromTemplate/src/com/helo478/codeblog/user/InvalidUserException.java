package com.helo478.codeblog.user;

/**
 * An Exception indicating that a given UserAccount was not found in the
 * persistence layer.
 * 
 * @author Donald Subert
 */
public class InvalidUserException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7946453113457920323L;

	/**
	 * Instantiates a new invalid user exception.
	 */
	public InvalidUserException() {
		super();
	}

}
