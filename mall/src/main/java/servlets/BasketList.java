package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.BasketofListVO;

@WebServlet("/BasketList.do")
public class BasketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BasketDao bDao = new BasketDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<BasketofListVO> list = bDao.getList((String)session.getAttribute("id"));
		
		request.setAttribute("blist",list);
		request.getRequestDispatcher("login/baskets.jsp").forward(request, response);
	}

}
