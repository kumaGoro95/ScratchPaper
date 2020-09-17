package test;


import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest{
	public static void main(String [] args) {
		testFindByLogin1();  //ユーザーが見つかる場合のテスト
		testFindByLogic2(); //ユーザーが見つからない場合のテスト
	}

	public static void testFindByLogin1() {
		Login login = new Login("kumagoro", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result != null && result.getName().equals("kumagoro") && result.getPass().equals("1234")){
			System.out.println("testFindByLogin1:成功しました");
		}else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}

	public static void testFindByLogic2() {
		Login login = new Login("kumagoro", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		}else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
