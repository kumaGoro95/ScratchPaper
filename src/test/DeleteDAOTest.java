package test;


import java.util.ArrayList;

import dao.PostDAO;
import model.Post;
import model.WrittenPost;

public class DeleteDAOTest{
	public static void main(String [] args) {
		deletePost();
		//loadPost();
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

	public static void deletePost() {
		Post post = new Post("kumagoro","くまごろー","これはテストです");
		System.out.println(post.getName());
		System.out.println(post.getText());
		PostDAO dao = new PostDAO();
		WrittenPost writtenPost = dao.addPost(post);
			System.out.println(writtenPost.getName());
			System.out.println(writtenPost.getText());
			System.out.println(writtenPost.getUserId());
		boolean result = dao.deletePostInfo(writtenPost);
		System.out.println(result);
	}
}
