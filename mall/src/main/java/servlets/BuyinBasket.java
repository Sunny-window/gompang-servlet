package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.BasketVO;

@WebServlet("/BuyinBasket.do")
public class BuyinBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasketDao bDao = new BasketDao();

		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("id");
		String[] pcodes = request.getParameterValues("selected");
		String[] samounts = request.getParameterValues("amount");
		
		System.out.println("요청한 user id : " + uid);
		for (String spcode : pcodes) {
			System.out.println("구매요청 상품 코드 : " + spcode);
		}
		for(String am : samounts) {
			System.out.println("구매 요청 수량 : " + am);
		}
		
		// 구매 구현

		// 구매한 항목들 장바구니에서 제거
		// 추후 구매 함수에서 구매 후 삭제되도록 이동시킬 것
		for (String spcode : pcodes) {
			bDao.deleteBasket(new BasketVO(uid, Integer.parseInt(spcode), 0));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
