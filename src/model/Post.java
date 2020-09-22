package model;

public class Post {
	private int postId;
	private String name;
	private String text;

	public Post(int postId, String name, String text) {
		this.postId = postId;
		this.name = name;
		this.text = text;
	}

	public Post(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public int getPostId() {
		return postId;
	}

	public String getName() {
		return name;
	}
	 public String getText() {
		 return text;
	 }

	 public void setPostId(int postId) {
		 this.postId = postId;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }
	 public void setText(String text) {
		 this.text = text;
	 }

}
