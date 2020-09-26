package model;

public class Account {
	private String userId;
	private String pass;
	private String name;
	private String icon;

	public Account(String userId, String pass, String name, String icon) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.icon = icon;
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
	public String getIcon() {
		return icon;
	}
}
