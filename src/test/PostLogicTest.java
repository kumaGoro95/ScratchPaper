package test;

import model.Post;
import model.PostLogic;

public class PostLogicTest {
	public static void main(String[] args) {
		testExecute1();  //投稿成功のテスト
	}
	public static void testExecute1() {
		Post post = new Post("kumagoro","くまごろー", "テストですよ");
		PostLogic bo = new PostLogic();
		boolean result = bo.execute(post);
		if(result) {
			System.out.println("testExecute1:成功しました");
		}else {
			System.out.println("testExecute1:失敗しました");
		}
	}
}
