package practice1015;

public class Product_ArrayList {
	private String code;
	private String name;
	private String color;
	private int qty; //제품수량
	
	public Product_ArrayList() {
		this ("000", "스마트폰", "블랙", 100);
	}
	
	public Product_ArrayList (String code, String name, String color, int qty) {
		this.code = code;
		this.name = name;
		this.color = color;
		this.qty = qty;
	}
	
	//setter, getter
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
