package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBcon;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String r = "t"; // 0 : 사용 불가 (중복) , 1 : 사용 가능
		String uid = request.getParameter("uid");
		String sql = "SELECT uid FROM user WHERE uid = ?";

		try {
			Connection conn = DBcon.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				r = "f";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(r);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
