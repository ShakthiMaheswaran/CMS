package models;

public class User {
	
	private String username;
	private String password;
	private int userid;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public int getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
