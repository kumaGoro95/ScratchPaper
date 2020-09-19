package model;

import dao.AccountDAO;

public class SignupLogic {
	public boolean execute(Signup signup) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.signupAccount(signup);
		return account != null;
	}

}
