package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVO;

@WebServlet("/M_productList.do")
public class M_ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao pDao = new ProductDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductVO> plist = pDao.getList();

		request.setAttribute("plist", plist);
		request.getRequestDispatcher("login/managerProductList.jsp").forward(request, response);
	}

}
