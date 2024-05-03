package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	private int pcode;
	private String title;
	private int price;
	private String pictureUrl;
	private String descript;
	private int stock;
}
