package com.scad.codeblog.persistence;

/**
 * A factory for creating BlogDao objects.
 * 
 * @author Donald Subert
 */
public interface BlogDaoFactory {

	/**
	 * Instantiate and return a new BlogDao object, used for persisting blog data.
	 *
	 * @return the blog dao
	 * @throws BlogDaoFactoryException, indicating that a new BlogDao could not be instantiated
	 */
	BlogDao getBlogDao() throws BlogDaoFactoryException;
}
