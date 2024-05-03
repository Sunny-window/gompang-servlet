package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.UserVO;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao uDao = new UserDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String username = request.getParameter("username");
		
		UserVO user = new UserVO(uid,username,"u");
		
		int result = uDao.registUser(user,pwd);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id",uid);
			session.setAttribute("username", username);
			response.sendRedirect("login/userpage.jsp");
		}

		else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
