package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.FindLogic;
import model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータからユーザーIDを取得
		String userId = request.getParameter("userId");

		//アカウントを取得
		User user = new User(userId);
		FindLogic bo = new FindLogic();
		Account userAccount = bo.getUserInfo(user);
		request.setAttribute("userAccount", userAccount);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
