package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.UserVO;

public class UserDao {
	Connection conn = DBcon.getConnection();
	ResultSet rs = null;

	public List<UserVO> getUserList() {
		List<UserVO> uList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT uid,username,type FROM user");

			while (rs.next()) {
				uList.add(new UserVO(rs.getString("uid"), rs.getString("username"), rs.getString("type")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uList;
	}
	
	public int registUser(UserVO user,String pwd) {
		String sql = "INSERT INTO user VALUES (?,?,?,default)";
		int r = 0;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUid() );
			stmt.setString(2, pwd);
			stmt.setString(3, user.getUsername());
			
			r = stmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return r;
	}
	
	public void deleteUser(UserVO user) {
		
		
		try {
			
		}catch(Exception e) {
			
		}
		
	}
	
}
