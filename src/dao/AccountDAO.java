package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountDAO {
	//DB接続用定数
    String DATABASE_NAME = "scratch_paper";
    String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
    String URL = "jdbc:mysql://localhost/" + DATABASE_NAME + PROPATIES;
    //DB接続用・ユーザ定数
    String USER = "root";
    String PASS = "";

	public Account findByLogin(User user){
		Account account = null;
		//データベースへ接続
		try {

			//MySQL に接続する
            Class.forName("com.mysql.jdbc.Driver");
            //データベースに接続
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

			//SELECT文を準備
			String sql = "SELECT PASS, NAME, USER_ID, ICON FROM ACCOUNT WHERE PASS = ? AND USER_ID = ?";
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
				String icon = rs.getString("ICON");
				account = new Account(userId, pass, name, icon);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、またはnullを返す
		return account;
	}

	public Account signupAccount(User user) {
		Account account = null;

		//データベースへ接続
		try {

			//MySQL に接続する
            Class.forName("com.mysql.jdbc.Driver");
            //データベースに接続
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

			//SELECT文を準備
			String duplicateCheckSql = "SELECT PASS, NAME, USER_ID, ICON FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt1 = conn.prepareStatement(duplicateCheckSql);
			pStmt1.setString(1, user.getUserId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs1 = pStmt1.executeQuery();

			if (rs1.next() == false) {
				//INSERT文を準備
				String insertSql = "INSERT INTO ACCOUNT(PASS, NAME, USER_ID, ICON) VALUES(?, ?, ?, ?)";
				PreparedStatement pStmt2 = conn.prepareStatement(insertSql);
				pStmt2.setString(1, user.getPass());
				pStmt2.setString(2, user.getName());
				pStmt2.setString(3, user.getUserId());
				pStmt2.setString(4, user.getIcon());

				//INSERT文を実行
				int result = pStmt2.executeUpdate();

				//SELECT文を準備
				String selectSql = "SELECT PASS, NAME, USER_ID, ICON FROM ACCOUNT WHERE PASS = ? AND NAME = ? AND USER_ID = ? AND ICON = ?";
				PreparedStatement pStmt3 = conn.prepareStatement(selectSql);
				pStmt3.setString(1, user.getPass());
				pStmt3.setString(2, user.getName());
				pStmt3.setString(3, user.getUserId());
				pStmt3.setString(4, user.getIcon());

				//SELECT文を実行し、結果表を取得
				ResultSet rs2 = pStmt3.executeQuery();

				//そのユーザーを表すAccountインスタンスを生成
				if (rs2.next()) {
					//結果表からデータを取得
					String userId = rs2.getString("USER_ID");
					String pass = rs2.getString("PASS");
					String name = rs2.getString("NAME");
					String icon = rs2.getString("ICON");
					account = new Account(userId, pass, name, icon);
					}
				} else {
					return null;
					}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		//作成したユーザー、またはnullを返す
		return account;
	}

	public Account findUserInfo(User user) {
		Account account = null;

		//データベースへ接続
		try {

			//MySQL に接続する
            Class.forName("com.mysql.jdbc.Driver");
            //データベースに接続
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

			//SELECT文を準備
			String sql = "SELECT PASS, NAME, USER_ID, ICON FROM ACCOUNT WHERE USER_ID = ?";
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
				String icon = rs.getString("ICON");
				account = new Account(userId, pass, name, icon);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、またはnullを返す
		return account;
	}

	public boolean deleteUserInfo(Account account){
		Account deletedAccount = null;

		//データベースへ接続
		try {

			//MySQL に接続する
            Class.forName("com.mysql.jdbc.Driver");
            //データベースに接続
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

			//DELETE文を準備
			String deleteSql = "DELETE FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt1 = conn.prepareStatement(deleteSql);
			pStmt1.setString(1, account.getUserId());

			//SELECT文を実行し、結果表を取得
			int result = pStmt1.executeUpdate();

			//SELECT文を準備
			String selectSql = "SELECT USER_ID FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(selectSql);
			pStmt2.setString(1, account.getUserId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt2.executeQuery();

			//該当ユーザーが削除されていればtrue
			//されていなければfalseを返す
			if (rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String name = rs.getString("NAME");
				String icon = rs.getString("ICON");
				deletedAccount = new Account(userId, pass, name, icon);
			}
			if(deletedAccount == null) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
