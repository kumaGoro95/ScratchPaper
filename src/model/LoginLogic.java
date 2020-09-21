package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(user);
		return account != null;
	}
}
