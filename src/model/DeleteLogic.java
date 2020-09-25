package model;

import dao.AccountDAO;
import dao.PostDAO;

public class DeleteLogic {
	public boolean deleteUser(Account account){
		AccountDAO dao = new AccountDAO();
		boolean isOk = dao.deleteUserInfo(account);
		return isOk;
	}

	public boolean deletePost(WrittenPost writtenPost){
		PostDAO dao = new PostDAO();
		boolean isOk = dao.deletePostInfo(writtenPost);
		return isOk;
	}
}
