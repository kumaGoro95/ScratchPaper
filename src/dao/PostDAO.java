package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.User;
import model.WrittenPost;

public class PostDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/testJavaApp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public  ArrayList<WrittenPost> loadPost() {

		//arrayListを用意
		List<WrittenPost> writtenPostList= new ArrayList<WrittenPost>();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT ID, NAME, TEXT FROM POST";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				WrittenPost writtenPost = new WrittenPost();
				writtenPost.setPostId(rs.getInt("ID"));
				writtenPost.setName(rs.getNString("NAME"));
				writtenPost.setText(rs.getNString("TEXT"));
				//ListにPostをaddしていく
				writtenPostList.add(writtenPost);
				}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、またはnullを返す
		return (ArrayList<WrittenPost>) writtenPostList;
	}

	public Account signupAccount(User user) {
		Account account = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String duplicateCheckSql = "SELECT USER_ID, PASS, NAME FROM ACCOUNT WHERE NAME = ?";
			PreparedStatement pStmt1 = conn.prepareStatement(duplicateCheckSql);
			pStmt1.setString(1, user.getName());

			//SELECT文を実行し、結果表を取得
			ResultSet rs1 = pStmt1.executeQuery();

			if (rs1.next() == false) {
				//INSERT文を準備
				String insertSql = "INSERT INTO ACCOUNT(PASS, NAME) VALUES(?, ?)";
				PreparedStatement pStmt2 = conn.prepareStatement(insertSql);
				pStmt2.setString(1, user.getPass());
				pStmt2.setString(2, user.getName());

				//INSERT文を実行
				int result = pStmt2.executeUpdate();

				//SELECT文を準備
				String selectSql = "SELECT USER_ID, PASS, NAME FROM ACCOUNT WHERE PASS = ? AND NAME = ?";
				PreparedStatement pStmt3 = conn.prepareStatement(selectSql);
				pStmt3.setString(1, user.getPass());
				pStmt3.setString(2, user.getName());

				//SELECT文を実行し、結果表を取得
				ResultSet rs2 = pStmt3.executeQuery();

				//そのユーザーを表すAccountインスタンスを生成
				if (rs2.next()) {
					//結果表からデータを取得
					String userId = rs2.getString("USER_ID");
					String pass = rs2.getNString("PASS");
					String name = rs2.getNString("NAME");
					account = new Account(userId, pass, name);
					}
				} else {
					return null;
					}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//作成したユーザー、またはnullを返す
		return account;
	}

}