package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/testJavaApp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Account findByLogic(Login login) {
		Account account = null;

		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT USER_ID, PASS, NAME FROM ACCOUNT WHERE PASS = ? AND NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getPass());
			pStmt.setString(2, login.getName());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getNString("PASS");
				String name = rs.getNString("NAME");
				account = new Account(userId, pass, name);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、またはnullを返す
		return account;
		}


}
