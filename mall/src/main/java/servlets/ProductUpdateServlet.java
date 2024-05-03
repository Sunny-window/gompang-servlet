package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import vo.ProductVO;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao pDao = new ProductDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MultipartRequest mr = new MultipartRequest(
				request,
				getServletContext().getRealPath("images"),
				5 * 1024 * 1024,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		
		String spcode = mr.getParameter("pcode");
		int pcode = Integer.parseInt(spcode);
		String title = mr.getParameter("title");
		String sprice = mr.getParameter("price");
		int price = Integer.parseInt(sprice);
		String pictureUrl = mr.getFilesystemName("imagefile");
		System.out.println("이미지 이름 : " + pictureUrl);
		String descript = mr.getParameter("descript");
		String sstock = mr.getParameter("stock");
		int stock = Integer.parseInt(sstock);
		
		ProductVO product = new ProductVO(pcode, title, price, pictureUrl, descript, stock);
		pDao.updateProduct(product);
		System.out.println(product);
		response.sendRedirect("M_productList.do");
	
	}
}
