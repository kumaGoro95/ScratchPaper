package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/testJavaApp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Account findByLogin(User user) {
		Account account = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT PASS, NAME, USER_ID FROM ACCOUNT WHERE PASS = ? AND USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getPass());
			pStmt.setString(2, user.getUserId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String name = rs.getString("NAME");
				account = new Account(userId, pass, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、またはnullを返す
		return account;
	}

	public Account signupAccount(User user) {
		Account account = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String duplicateCheckSql = "SELECT PASS, NAME, USER_ID FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt1 = conn.prepareStatement(duplicateCheckSql);
			pStmt1.setString(1, user.getUserId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs1 = pStmt1.executeQuery();

			if (rs1.next() == false) {
				//INSERT文を準備
				String insertSql = "INSERT INTO ACCOUNT(PASS, NAME, USER_ID) VALUES(?, ?, ?)";
				PreparedStatement pStmt2 = conn.prepareStatement(insertSql);
				pStmt2.setString(1, user.getPass());
				pStmt2.setString(2, user.getName());
				pStmt2.setString(3, user.getUserId());

				//INSERT文を実行
				int result = pStmt2.executeUpdate();

				//SELECT文を準備
				String selectSql = "SELECT PASS, NAME, USER_ID FROM ACCOUNT WHERE PASS = ? AND NAME = ? AND USER_ID = ?";
				PreparedStatement pStmt3 = conn.prepareStatement(selectSql);
				pStmt3.setString(1, user.getPass());
				pStmt3.setString(2, user.getName());
				pStmt3.setString(3, user.getUserId());

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

	public Account findUserInfo(User user) {
		Account account = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT PASS, NAME, USER_ID FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String name = rs.getString("NAME");
				account = new Account(userId, pass, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、またはnullを返す
		return account;
	}

}
