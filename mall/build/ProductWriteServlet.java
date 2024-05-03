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

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDao pDao = new ProductDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String savePath = "images";
		int fileLimitSize = 5 * 1024 * 1024;
		String enc = "utf-8";
		String path = getServletContext().getRealPath(savePath);
		
		MultipartRequest mr = new MultipartRequest(
				request, 
				path, 
				fileLimitSize, 
				enc, 
				new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title");
		String sprice = mr.getParameter("price");
		int price = Integer.parseInt(sprice);
		String pictureUrl = mr.getFilesystemName("imagefile");
		String descript = mr.getParameter("descript");
		
		ProductVO product = new ProductVO(0, title, price, pictureUrl, descript);
		pDao.saveProduct(product);
		
		System.out.println(product);
		response.sendRedirect("managerProductList.do");
		
	}

}
