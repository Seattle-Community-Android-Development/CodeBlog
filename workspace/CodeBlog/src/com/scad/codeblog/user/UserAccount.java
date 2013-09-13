package com.scad.codeblog.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount {

	@Id
	private int userId;
	private String userName;
	private byte[] passwordHash;

	private UserManager userManager;

	private boolean isBlogger;

	public UserAccount() {
		super();
	}

	public UserAccount(final String userName, final byte[] passwordHash) {
		this.userName = userName;
		this.passwordHash = passwordHash;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(final int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	protected byte[] getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(final byte[] newPasswordHash) {
		this.passwordHash = newPasswordHash;
	}

	/**
	 * Sets a user manager, if it is not already set
	 * 
	 * @param userManager
	 */
	protected void setUserManager(final UserManager userManager) {

		if (this.userManager == null) {
			this.userManager = userManager;
		}
	}

	public void changePassword(final byte[] oldPasswordHash,
			final byte[] newPasswordHash) {
		
		this.userManager.changePassword(this, oldPasswordHash, newPasswordHash);
	}

	final public void setIsBlogger(final boolean b) {
		this.isBlogger = b;
	}

	final public boolean isBlogger() {
		return this.isBlogger;
	}
}