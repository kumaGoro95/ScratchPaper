package model;

import dao.AccountDAO;
import dao.PostDAO;

public class FindLogic {
	public Account getUserInfo(User user){
		AccountDAO dao = new AccountDAO();
		Account account = dao.findUserInfo(user);
		return account;
	}

	public WrittenPost getPostInfo(Post post){
		PostDAO dao = new PostDAO();
		WrittenPost writtenPost = dao.findPostInfo(post);
		return writtenPost;
	}
}
