package com.scad.codeblog.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.scad.codeblog.user.UserAccount;

public class UserAccountTest {
	
	private static final int TEST_USER_ID = 1;

	private static final String TEST_USER_NAME = "TEST_USER_NAME";
	
	private UserAccount userAccount;
	
	@Before
	public void setUp() {
		this.userAccount = new UserAccount();
	}

	@Test
	public void setUserIdTest() {
		this.userAccount.setUserId(TEST_USER_ID);
	}
	
	@Test
	public void setUserNameTest() {
		this.userAccount.setUserName(TEST_USER_NAME);
	}
	
	@Test
	public void getUserIdTest() {
		this.userAccount.setUserId(TEST_USER_ID);
		assertEquals(TEST_USER_ID, this.userAccount.getUserId());
	}
	
	@Test
	public void getUserNameTest() {
		this.userAccount.setUserName(TEST_USER_NAME);
		assertEquals(TEST_USER_NAME, this.userAccount.getUserName());
	}

}
