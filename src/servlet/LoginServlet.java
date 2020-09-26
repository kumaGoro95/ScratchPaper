package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.LoginLogic;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginUser = (Account)session.getAttribute("account");
		if (loginUser == null){
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		} else {
			//ログイン済ならmainへ
			request.setAttribute("errorMsg", "すでにログイン済です");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		//ログイン処理の実行
		User user = new User(userId,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(user);

		//ログイン処理の成否によって処理を分岐
		if(result) { //ログイン成功時
			Account account = bo.getUserInfo(user);
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			//リダイレクト
			response.sendRedirect("/testJavaApp/PostsServlet");
		}else { //ログイン失敗時
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "ユーザー名、またはパスワードが間違っています");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
