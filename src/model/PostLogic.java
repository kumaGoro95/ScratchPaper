package model;

import dao.PostDAO;

public class PostLogic {
	public boolean execute(Post post) {
		PostDAO dao = new PostDAO();
		WrittenPost writtenPost = dao.addPost(post);
		return writtenPost != null;
	}

}
