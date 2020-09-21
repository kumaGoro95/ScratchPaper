package model;

import java.util.ArrayList;

import dao.PostDAO;

public class PostGetLogic {
	public ArrayList<WrittenPost> execute() {
		PostDAO dao = new PostDAO();
		ArrayList<WrittenPost> writtenPostList = dao.loadPost();
		return writtenPostList;
	}
}
