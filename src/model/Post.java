package model;

public class Post {
	private int postId;
	private String userId;
	private String name;
	private String text;

	public Post(int postId, String userId, String name, String text) {
		this.postId = postId;
		this.userId = userId;
		this.name = name;
		this.text = text;
	}

	public Post(String userId, String name, String text) {
		this.userId = userId;
		this.name = name;
		this.text = text;
	}

	public Post(int postId) {
		this.postId = postId;
	}

	public int getPostId() {
		return postId;
	}

	public String getUserId() {
		return userId;
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

	 public void setUserId(String userId) {
		 this.userId = userId;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }
	 public void setText(String text) {
		 this.text = text;
	 }

}
