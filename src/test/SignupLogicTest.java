package test;

import model.SignupLogic;
import model.User;

public class SignupLogicTest {
	public static void main(String[] args) {
		testExecute1();  //ログイン成功のテスト
	}
	public static void testExecute1() {
		User user = new User("kumachan", "1324");
		SignupLogic bo = new SignupLogic();
		boolean result = bo.execute(user);
		if(result) {
			System.out.println("testExecute1:成功しました");
		}else {
			System.out.println("testExecute1:失敗しました");
		}
	}
}
