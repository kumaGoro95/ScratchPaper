package test;


import java.util.ArrayList;

import dao.PostDAO;
import model.Post;
import model.WrittenPost;

public class PostDAOTest{
	public static void main(String [] args) {
		//loadPost();
		addPost();
	}

	public static void loadPost() {
		PostDAO dao = new PostDAO();
		ArrayList<WrittenPost> writtenPostList = dao.loadPost();

	    for (int i = 0 ; i < writtenPostList.size() ; i++){
	      WrittenPost wp =writtenPostList.get(i);
	      System.out.println(wp.getName());
	      System.out.println(wp.getText());
	    }
	}

	public static void addPost() {
		Post post = new Post("kumagoro","くまごろー","こんにちはー");
		System.out.println(post.getName());
		System.out.println(post.getText());
		PostDAO dao = new PostDAO();
		WrittenPost writtenPost = dao.addPost(post);
			System.out.println(writtenPost.getName());
			System.out.println(writtenPost.getText());
			System.out.println(writtenPost.getUserId());
	}
}
