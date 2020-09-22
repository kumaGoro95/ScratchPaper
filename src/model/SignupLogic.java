package model;

import dao.AccountDAO;

public class SignupLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.signupAccount(user);
		return account != null;
	}

	public Account getUserInfo(User user){
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(user);
		return account;
	}

}
