package model;

public class Login {
	private String name;
	private String pass;

	public Login(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}

}
