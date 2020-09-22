package model;

public class User {
	private String userId;
	private String name;
	private String pass;

	public User(String userId,String name, String pass) {
		this.userId = userId;
		this.name = name;
		this.pass = pass;
	}

	public User(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public User(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	 public String getPass() {
		 return pass;
	 }
}
