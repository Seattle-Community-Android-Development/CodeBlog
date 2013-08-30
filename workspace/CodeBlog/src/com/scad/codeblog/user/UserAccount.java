package com.scad.codeblog.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount {

	@Id
	private int userId;
	private String userName;
	
	//private UserManager userManager;
	
	private boolean isBlogger;
	
	public UserAccount() {
		super();
	}
	
	public UserAccount(final String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public void setUserManager(UserManager userManager) {

		if (this.userManager == null) {
			this.userManager = userManager;
		}
	}*/
	
	final public void setIsBlogger(final boolean b) {
		this.isBlogger = b;
	}
	
	final public boolean isBlogger() {
		return this.isBlogger;
	}
}