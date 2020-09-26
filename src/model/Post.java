package model;

public class Post {
	private int postId;
	private String userId;
	private String name;
	private String text;
	private String icon;

	public Post(int postId, String userId, String name, String text, String icon) {
		this.postId = postId;
		this.userId = userId;
		this.name = name;
		this.text = text;
		this.icon = icon;
	}

	public Post(String userId, String name, String text, String icon) {
		this.userId = userId;
		this.name = name;
		this.text = text;
		this.icon = icon;
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
	 public String getIcon() {
		 return icon;
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
	 public void setIcon(String icon) {
		 this.icon = icon;
	 }

}
