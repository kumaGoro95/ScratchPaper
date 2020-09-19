package test;

import model.Signup;
import model.SignupLogic;

public class SignupLogicTest {
	public static void main(String[] args) {
		testExecute1();  //ログイン成功のテスト
	}
	public static void testExecute1() {
		Signup signup = new Signup("kumachan", "1324");
		SignupLogic bo = new SignupLogic();
		boolean result = bo.execute(signup);
		if(result) {
			System.out.println("testExecute1:成功しました");
		}else {
			System.out.println("testExecute1:失敗しました");
		}
	}
}
