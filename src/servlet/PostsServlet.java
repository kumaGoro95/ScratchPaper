package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostGetLogic;
import model.WrittenPost;

@WebServlet("/PostsServlet")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ツイート一覧を取得
		PostGetLogic bo = new PostGetLogic();
		List<WrittenPost> writtenPostList= new ArrayList<WrittenPost>();
		writtenPostList = bo.execute();
		//リクエストスコープに保存
		request.setAttribute("writtenPostList", writtenPostList);

		//つぶやきリストをアプリケーションスコープから取得
		//ServletContext application = this.getServletContext();
		//List<Post> postList = (List<Post>) application.getAttribute("postList");

		//取得できなければ、新規作成してアプリケーションスコープに保存
		//if(postList == null) {
			//postList = new ArrayList<>();
			//application.setAttribute("postList", postList);
		//}

		//ログインしているかを確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("userName");

		if(loginUser == null) {  //ログインしていない場合
			//リダイレクト
			response.sendRedirect("/testJavaApp/LoginServlet");
		}else {  //ログイン済の場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
