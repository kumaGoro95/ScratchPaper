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
import model.SignupLogic;
import model.User;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUser = (String)session.getAttribute("account");
		if (loginUser == null) {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/testJavaApp/PostsServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account account = null;

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId= request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String icon = "default.png";

		if(pass.length() < 4) {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "パスワードは４文字以上で設定してください");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//会員登録処理の実行
		User user = new User(userId, name, pass, icon);
		SignupLogic bo = new SignupLogic();
		boolean result = bo.execute(user);

		//会員登録処理の成否によって処理を分岐
		if (result) { //登録成功時
			account = bo.getUserInfo(user);
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			//リダイレクト
			response.sendRedirect("/testJavaApp/PostsServlet");
		} else { //登録失敗時
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "ユーザー名、またはパスワードが不正です");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
		}
	}
}
