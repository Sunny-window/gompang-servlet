package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ProductVO;

public class ProductDao {
	Connection conn = DBcon.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public List<ProductVO> getList(){
		List<ProductVO> plist = new ArrayList<>();
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM product");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int pcode = rs.getInt("pcode");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				String pictureUrl = rs.getString("pictureUrl");
				String descript = rs.getString("descript");
				int stock = rs.getInt("stock");
				
				ProductVO product = new ProductVO(pcode, title, price, pictureUrl, descript, stock);
				plist.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plist;
	}
	
	public ProductVO getProduct(int pcode) {
		String query = "SELECT * FROM product WHERE pcode = ?";
		ProductVO product = null;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, pcode);
			
			rs = stmt.executeQuery();
			
			rs.next();
			
			//int pcode = rs.getInt("pcode");
			String title = rs.getString("title");
			int price = rs.getInt("price");
			String pictureUrl = rs.getString("pictureUrl");
			String descript = rs.getString("descript");
			int stock = rs.getInt("stock");
			
			product = new ProductVO(pcode, title, price, pictureUrl, descript, stock);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	//등록
	public void saveProduct(ProductVO product) {
		String query = "INSERT INTO product VALUES (null, ?, ?, ?, ?, ?)";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, product.getTitle());
			stmt.setInt(2, product.getPrice());
			stmt.setString(3, product.getPictureUrl());
			stmt.setString(4, product.getDescript());
			stmt.setInt(5, product.getStock());
			int result = stmt.executeUpdate();
			System.out.println("등록 결과 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//삭제
	public void delProduct(int pcode) {
		System.out.println("delete pcode : " + pcode);
		String query = "DELETE FROM product WHERE pcode = ?";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, pcode);
			
			int result = stmt.executeUpdate();
			
			System.out.println("삭제 결과 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//수정
	public void updateProduct(ProductVO product) {
		String query = "UPDATE product SET title = ?, price = ?, descript = ?, stock = ? WHERE pcode = ?";
		String query2 = "UPDATE product SET title = ?, price = ?, pictureUrl = ?, descript = ?, stock = ? WHERE pcode = ?";
		int result = -1;
		
		if(product.getPictureUrl() == null) {
			System.out.println("이미지 널일때...수행중");
			try {
				stmt = conn.prepareStatement(query);
				stmt.setString(1, product.getTitle());
				stmt.setInt(2, product.getPrice());
				stmt.setString(3, product.getDescript());
				stmt.setInt(4, product.getStock());
				stmt.setInt(5, product.getPcode());
				result = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("이미지 널 아닐때...수행중");
			try {
				stmt = conn.prepareStatement(query2);
				stmt.setString(1, product.getTitle());
				stmt.setInt(2, product.getPrice());
				stmt.setString(3, product.getPictureUrl());
				stmt.setString(4, product.getDescript());
				stmt.setInt(5, product.getStock());
				stmt.setInt(6, product.getPcode());
				result = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("수정 결과 : " + result);
	}
}
