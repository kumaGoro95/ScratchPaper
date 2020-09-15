package model;

public class Account {
	private String userId;
	private String pass;
	private String name;

	public Account(String userId, String pass, String name) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
}
