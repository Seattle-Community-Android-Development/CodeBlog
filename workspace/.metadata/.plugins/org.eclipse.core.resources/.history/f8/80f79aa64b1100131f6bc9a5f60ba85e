package com.scad.codeblog.user;

public interface UserManager {
	
	UserAccount createUser(String userName, byte[] passwordHash) throws UserManagerException;
	
	UserAccount loginUser(String userName, byte[] passwordHash) throws UserManagerException;
	
	void deleteUser(long userId) throws UserManagerException;
	
	void reset() throws UserManagerException;
	
	void close() throws UserManagerException;
	
}
