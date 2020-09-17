package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean extcute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
}
