package models;

public class Authehnticator {
	
	public Authehnticator() {
		
	}
	
	public boolean authenticateLogin(User user) {
		if("admin".equals(user.getUsername())&& "password".equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	

}
