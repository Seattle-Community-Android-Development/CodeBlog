package com.javabrains.webmvc.service;

import java.util.HashMap;
import java.util.Map;

import com.javabrains.webmvc.dto.User;

public class LoginService {
	
	private final Map<String, String> users;
	
	public LoginService() {
		super();
		
		users = new HashMap<String, String>();
		
		addDummyUsers(); // TODO: change this
	}

	private void addDummyUsers() {
		users.put("chatred", "Sergent Hatred");
		users.put("hventure", "The Hankenator");
		users.put("jventure", "JJ");
		users.put("bsamson", "Brock Samson");
	}

	public boolean authenticate(final String userId, final String password) {
		return new PasswordAuthenticator(userId, password).authenticate();
	}
	
	public User getUser(final String userId) {
		final User user = new User();
		user.setUserId(userId);
		user.setUserName(users.get(userId));
		return user;
	}

	private class PasswordAuthenticator {

		private final String userId;
		private final String password;

		private PasswordAuthenticator(final String userId, final String password) {
			this.userId = userId;
			this.password = password;
		}

		private boolean authenticate() {
			if (
					userIdNotNull() && 
					userIdNotEmpty() && 
					userIdValid() && 
					passwordNotNull() && 
					passwordNotEmpty() && 
					passwordMatches()
			) {
				return true;

			} else {
				return false;
			}
		}

		private boolean userIdNotNull() {
			return this.userId != null;
		}

		private boolean userIdNotEmpty() {
			return (!this.userId.isEmpty());
		}

		private boolean userIdValid() {
			return users.containsKey(userId);
		}

		private boolean passwordNotNull() {
			return this.password != null;
		}

		private boolean passwordNotEmpty() {
			return (!this.password.isEmpty());
		}

		private boolean passwordMatches() {
			return true;
			// TODO: implement
		}
	}
}
