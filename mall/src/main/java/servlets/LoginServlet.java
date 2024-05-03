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
import javax.servlet.http.HttpSession;

import dao.DBcon;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String sql = "SELECT * FROM user WHERE uid = ? AND pwd = ?";
		try {
			Connection conn = DBcon.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("id",uid);
				session.setAttribute("username",rs.getString("username"));
				if(uid.equals("root")) {
					response.sendRedirect("login/managerPage.jsp");
				}
				else {
					response.sendRedirect("login/userpage.jsp");
				}
			}
			else { 
				response.sendRedirect("index.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
