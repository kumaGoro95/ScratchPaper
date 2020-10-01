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
import model.DeleteLogic;
import model.WrittenPost;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasSucceed = false;

		//リクエストパラメータから取得
		String action = request.getParameter("action");

		try {
			//Post削除
			if (action.equals("posts")) {
				HttpSession session1 = request.getSession();
				WrittenPost writtenPost = (WrittenPost) session1.getAttribute("postDetail");
				DeleteLogic bo = new DeleteLogic();
				hasSucceed = bo.deletePost(writtenPost);
				//リダイレクト
				response.sendRedirect("/ScratchPaper/posts");
			}

			//User削除
			if (action.equals("user")) {
				HttpSession session = request.getSession();
				Account account = (Account) session.getAttribute("account");
				DeleteLogic bo = new DeleteLogic();
				hasSucceed = bo.deleteUser(account);

				//セッションスコープを破棄
				HttpSession session2 = request.getSession();
				session2.invalidate();

				//リダイレクト
				response.sendRedirect("/ScratchPaper/index");
			}

			if (hasSucceed) {
				request.setAttribute("errorMsg", "削除しました");
			} else {
				request.setAttribute("errorMsg", "削除が失敗しました");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasSucceed = false;

		//リクエストパラメータから取得
		String action = request.getParameter("action");

		try {
			//Post削除
			if (action.equals("posts")) {
				HttpSession session = request.getSession();
				WrittenPost writtenPost = (WrittenPost) session.getAttribute("postDetail");
				DeleteLogic bo = new DeleteLogic();
				hasSucceed = bo.deletePost(writtenPost);
			}

			//User削除
			if (action.equals("user")) {
				HttpSession session = request.getSession();
				Account account = (Account) session.getAttribute("account");
				DeleteLogic bo = new DeleteLogic();
				hasSucceed = bo.deleteUser(account);
			}

			if (hasSucceed) {
				request.setAttribute("errorMsg", "削除しました");
			} else {
				request.setAttribute("errorMsg", "削除が失敗しました");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
