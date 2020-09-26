package model;

public class User {
	private String userId;
	private String name;
	private String pass;
	private String icon;

	public User(String userId,String name, String pass, String icon) {
		this.userId = userId;
		this.name = name;
		this.pass = pass;
		this.icon = icon;
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

	 public String getIcon() {
		 return icon;
	 }
}
