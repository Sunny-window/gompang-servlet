package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.BasketVO;
import vo.BasketofListVO;

public class BasketDao {
	Connection conn = DBcon.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public void putIn(BasketVO basket) {
		String sql = "INSERT INTO basket VALUES (?, ?, ?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,basket.getUid());
			stmt.setInt(2,basket.getPcode());
			stmt.setInt(3,basket.getAmount());
			
			int result = stmt.executeUpdate();
			System.out.println("등록 결과 : " + result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void putInBefore(BasketVO basket) {
		String sql ="SELECT amount FROM basket WHERE uid = ? AND pcode = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, basket.getUid());
			stmt.setInt(2, basket.getPcode());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				int amount = rs.getInt("amount");
				basket.setAmount(basket.getAmount()+amount);
				deleteBasket(basket);
			}
			System.out.println(basket);
			if(basket.getAmount() == 0) {
				System.out.println("수량 0 확인되어 데이터 삽입하지 않음.");
			}
			else {
				putIn(basket);
			}
		}
		catch(Exception e) {
			
		}
		
	}
	
	public void deleteBasket(BasketVO basket) {
		String sql = "DELETE FROM basket WHERE uid = ? AND pcode = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,basket.getUid());
			stmt.setInt(2,basket.getPcode());
			
			int result = stmt.executeUpdate();
			System.out.println("삭제 결과 : " + result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public List<BasketofListVO> getList(String uid) {
		List<BasketofListVO> list = new ArrayList<>();

		String sql = "SELECT p.title, p.price, b.amount, p.price * b.amount AS totalPrice , p.pictureUrl, p.pcode, p.stock "
				+ "FROM basket b JOIN product p "
				+ "ON b.pcode = p.pcode "
				+ "WHERE uid = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,uid);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BasketofListVO(
					rs.getString("title"),
					rs.getInt("price"),
					rs.getInt("amount"),
					rs.getInt("totalPrice"),
					rs.getString("p.pictureUrl"),
					rs.getInt("pcode"),
					rs.getInt("stock")
				));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
