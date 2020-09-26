package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;
import model.WrittenPost;

public class PostDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/testJavaApp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public ArrayList<WrittenPost> loadPost() {

		//arrayListを用意
		List<WrittenPost> writtenPostList= new ArrayList<WrittenPost>();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT ID, NAME, TEXT, USER_ID, ICON FROM POST";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				WrittenPost writtenPost = new WrittenPost();
				writtenPost.setPostId(rs.getInt("ID"));
				writtenPost.setName(rs.getNString("NAME"));
				writtenPost.setText(rs.getNString("TEXT"));
				writtenPost.setUserId(rs.getNString("USER_ID"));
				writtenPost.setIcon(rs.getNString("ICON"));
				//ListにPostをaddしていく
				writtenPostList.add(writtenPost);
				}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったpost、またはnullを返す
		return (ArrayList<WrittenPost>) writtenPostList;
	}

	public WrittenPost addPost(Post post) {

		WrittenPost writtenPost = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文を準備
			String insertSql = "INSERT INTO POST(NAME, TEXT, USER_ID, ICON) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt1 = conn.prepareStatement(insertSql);
			pStmt1.setString(1, post.getName());
			pStmt1.setString(2, post.getText());
			pStmt1.setString(3, post.getUserId());
			pStmt1.setString(4, post.getIcon());

			//INSERT文を実行
			int result = pStmt1.executeUpdate();

			//SELECT文を準備
			String selectSql = "SELECT ID, NAME, TEXT, USER_ID, ICON FROM POST WHERE NAME = ? AND TEXT = ? AND USER_ID = ? AND ICON = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(selectSql);
			pStmt2.setString(1, post.getName());
			pStmt2.setString(2, post.getText());
			pStmt2.setString(3, post.getUserId());
			pStmt2.setString(4, post.getIcon());

			//SELECT文を実行し、結果表を取得
			ResultSet rs2 = pStmt2.executeQuery();

			//そのユーザーを表すWrittenPostインスタンスを生成
			if (rs2.next()) {
				//結果表からデータを取得
				int postId = rs2.getInt("ID");
				String name = rs2.getNString("NAME");
				String text = rs2.getNString("TEXT");
				String userId = rs2.getString("USER_ID");
				String icon = rs2.getNString("ICON");
				writtenPost = new WrittenPost(postId, userId, name, text, icon);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//投稿したwrittenPost、またはnullを返す
		return writtenPost;
	}

	public WrittenPost findPostInfo(Post post) {

		WrittenPost writtenPost = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT ID, NAME, TEXT, USER_ID, ICON FROM POST WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, post.getPostId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				int postId = post.getPostId();
				String name = rs.getString("NAME");
				String text = rs.getString("TEXT");
				String userId = rs.getString("USER_ID");
				String icon = rs.getNString("ICON");
				writtenPost = new WrittenPost(postId, userId, name, text, icon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったpost、またはnullを返す
		return writtenPost;
	}

	public boolean deletePostInfo(WrittenPost writtenPost) {
		WrittenPost deletedPost = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//DELETE文を準備
			String deleteSql = "DELETE FROM POST WHERE ID = ?;";
			PreparedStatement pStmt1 = conn.prepareStatement(deleteSql);
			pStmt1.setInt(1, writtenPost.getPostId());

			//DELETE文を実行
			int result = pStmt1.executeUpdate();

			//SELECT文を準備
			String selectSql = "SELECT ID, NAME, TEXT, USER_ID, ICON FROM POST WHERE ID = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(selectSql);
			pStmt2.setInt(1, writtenPost.getPostId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt2.executeQuery();

			if (rs.next()) {
				//結果表からデータを取得
				int postId = rs.getInt("ID");
				String name = rs.getString("NAME");
				String text = rs.getString("TEXT");
				String userId = rs.getString("USER_ID");
				String icon = rs.getNString("ICON");
				deletedPost = new WrittenPost(postId, userId, name, text, icon);
			}

			if(deletedPost == null) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		}
}