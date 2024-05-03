package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BasketDao;
import vo.BasketVO;

@WebServlet("/PutInBasket.do")
public class PutInBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BasketDao bDao = new BasketDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		BasketVO bk = new BasketVO();

		bk = new BasketVO(req.getParameter("uid"), Integer.parseInt(req.getParameter("pcode")),
				Integer.parseInt(req.getParameter("amount")));

		bDao.putInBefore(bk);
		System.out.println(bk);
		res.sendRedirect("productList.do");

	}

}
