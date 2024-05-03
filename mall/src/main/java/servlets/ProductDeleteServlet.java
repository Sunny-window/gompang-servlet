package servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao pDao = new ProductDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spcode = request.getParameter("pcode");
		int pcode = Integer.parseInt(spcode);
		String pictureUrl = request.getParameter("pictureUrl");
		if(pictureUrl != "default.png") {
			ServletContext ctx = getServletContext();
			File file = new File(ctx.getRealPath("images/") + pictureUrl);
			file.delete();
		}
		
		pDao.delProduct(pcode);
		
		response.sendRedirect("M_productList.do");
	}
	
	

}
