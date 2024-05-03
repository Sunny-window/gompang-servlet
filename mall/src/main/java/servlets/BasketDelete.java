package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BasketDao;
import vo.BasketVO;

@WebServlet("/BasketDelete.do")
public class BasketDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BasketDao bDao = new BasketDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		
		BasketVO b = new BasketVO(uid,pcode,0);
		bDao.deleteBasket(b);
		
		response.sendRedirect("BasketList.do?id="+uid);
	}
	

}
