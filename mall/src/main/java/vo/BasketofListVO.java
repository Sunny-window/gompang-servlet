package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasketofListVO {
	private String title;
	private int price;
	private int amount;
	private int totalprice;
	private String pictureUrl;
	private int pcode;
	private int stock;
}
