package com.scad.codeblog.persistence;

/**
 * The Class BlogDaoFactoryException.
 */
public class BlogDaoFactoryException extends Exception {

	/**
	 * Version Id.
	 */
	private static final long serialVersionUID = -6072977445883361253L;

	/**
	 * Instantiates a new blog dao factory exception.
	 */
	public BlogDaoFactoryException() {
		super();
	}
	
	/**
	 * Instantiates a new blog dao factory exception.
	 *
	 * @param message the message describing the exception condition
	 */
	public BlogDaoFactoryException(final String message) {
		super(message);
	}
	
	/**
	 * Instantiates a new blog dao factory exception.
	 *
	 * @param message the message describing the exception condition
	 * @param cause the exception causing this exception
	 */
	public BlogDaoFactoryException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Instantiates a new blog dao factory exception.
	 *
	 * @param cause the exception causing this exception
	 */
	public BlogDaoFactoryException(final Throwable cause) {
		super(cause);
	}
}
