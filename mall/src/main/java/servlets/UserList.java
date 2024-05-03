package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import vo.UserVO;

@WebServlet("/UserList.do")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao uDao = new UserDao();
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserVO> ulist = uDao.getUserList();
		
		request.setAttribute("userlist",ulist);
		request.getRequestDispatcher("login/managerPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
