package model;

import dao.AccountDAO;

public class LoginLogic {
	Account account = null;

	public boolean execute(User user1) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(user1);
		return account != null;
	}
	public Account getUserInfo(User user){
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(user);
		return account;
	}
}
