package model;

import dao.AccountDAO;

public class SignupLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.signupAccount(user);
		return account != null;
	}

}
