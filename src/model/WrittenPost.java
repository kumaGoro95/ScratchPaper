package model;

import java.io.Serializable;

public class WrittenPost implements Serializable{
	private int postId;
	private String text;
	private String name;

	public WrittenPost() {}

	public WrittenPost(int postId, String name,String text) {
		this.postId = postId;
		this.name = name;
		this.text = text;
	}

	public int getPostId() {
		return postId;
	}
	public String getText() {
		return text;
	}
	public String getName() {
		return name;
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
