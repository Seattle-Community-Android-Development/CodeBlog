package com.scad.codeblog.user;

import com.scad.codeblog.persistence.BlogDao;

/**
 * A factory for creating UserManager objects.
 * 
 * @author Donald Subert
 */
public interface UserManagerFactory {
	
	/**
	 * Gets the user manager.
	 *
	 * @param blogDao the blog dao
	 * @return the user manager
	 */
	UserManager getUserManager(BlogDao blogDao);

}
