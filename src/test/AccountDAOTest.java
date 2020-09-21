package test;


import dao.AccountDAO;
import model.Account;
import model.User;

public class AccountDAOTest{
	public static void main(String [] args) {
		testFindByLogin1();  //ユーザーが見つかる場合のテスト
		testFindByLogic2(); //ユーザーが見つからない場合のテスト
		testSignupAccountLogic1();  //ユーザー作成のテスト
	}

	public static void testFindByLogin1() {
		User user = new User("kumagoro", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(user);
		if(result != null && result.getName().equals("kumagoro") && result.getPass().equals("1234")){
			System.out.println("testFindByLogin1:成功しました");
		}else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}

	public static void testFindByLogic2() {
		User user = new User("kumagoro", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(user);
		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		}else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}

	public static void testSignupAccountLogic1() {
		User user = new User("monokuma", "1313");
		AccountDAO dao = new AccountDAO();
		Account result = dao.signupAccount(user);
		if(result != null && result.getName().equals("monokuma") && result.getPass().equals("1313")){
			System.out.println("testSignupAccountLogic1:成功しました");
		}else {
			System.out.println("testSignupAccountLogic1:失敗しました");
		}
	}
}
