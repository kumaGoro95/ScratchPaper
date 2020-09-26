package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Post;
import model.PostGetLogic;
import model.PostLogic;
import model.WrittenPost;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginUser = (Account) session.getAttribute("account");
		if (loginUser != null){ //ログインしている場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
			dispatcher.forward(request, response);
		} else {
			//未ログインならログイン画面へ
			response.sendRedirect("/testJavaApp/LoginServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("post");

		//セッションスコープからユーザー名を取得
		HttpSession session = request.getSession();
		Account loginUser = (Account) session.getAttribute("account");
		String userId = loginUser.getUserId();
		String name = loginUser.getName();
		String icon = loginUser.getIcon();


		if(text.length() > 150) {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "150文字以内で入力してください");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//投稿処理の実行
		Post post = new Post(userId,name,text,icon);
		PostLogic bo1 = new PostLogic();
		boolean result = bo1.execute(post);

		//投稿処理成功の可否で処理を分岐
		if(result) {  //投稿成功時
			//ツイート一覧を取得
			PostGetLogic bo2 = new PostGetLogic();
			List<WrittenPost> writtenPostList= new ArrayList<WrittenPost>();
			writtenPostList = bo2.execute();

			//アプリケーションスコープに保存
			ServletContext application = this.getServletContext();
			application.setAttribute("writtenPostList",writtenPostList);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}else {  //投稿失敗時
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "投稿が失敗しました");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
			dispatcher.forward(request, response);
		}



	}

}
