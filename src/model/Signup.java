package model;

public class Signup {
	private String name;
	private String pass;

	public Signup(String name, String pass) {
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
