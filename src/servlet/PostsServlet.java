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
import model.FindLogic;
import model.Post;
import model.PostGetLogic;
import model.WrittenPost;

@WebServlet("/PostsServlet")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postIdStr = request.getParameter("postId");
		if(postIdStr != null) {
			int postId = Integer.parseInt(postIdStr);

			//アカウントを取得
			Post post = new Post(postId);
			FindLogic bo = new FindLogic();
			WrittenPost writtenPost = bo.getPostInfo(post);
			HttpSession session = request.getSession();
			session.setAttribute("postDetail", writtenPost);
			//request.setAttribute("postDetail", writtenPost);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/postdetail.jsp");
			dispatcher.forward(request, response);
		}

		//ツイート一覧を取得
		PostGetLogic bo = new PostGetLogic();
		List<WrittenPost> writtenPostList= new ArrayList<WrittenPost>();
		writtenPostList = bo.execute();

		//アプリケーションスコープに保存
		ServletContext application = this.getServletContext();
		application.setAttribute("writtenPostList",writtenPostList);

		//ログインしているかを確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		Account loginUser = (Account) session.getAttribute("account");

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
