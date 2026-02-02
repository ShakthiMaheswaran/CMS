package models;

public class Authenticator {
	
	public Authenticator() {
		
	}
	
	public boolean authenticateLogin(User user) {
		if("admin".equals(user.getUsername())&& "password".equals(user.getPassword())) {
			return true;
		}
		return false;
	}

}
