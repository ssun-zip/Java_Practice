package practice1015;

import java.util.*;

public class ProductTest_ArrayList {
	private void getProductTest_Set(ArrayList list) {
		Product_ArrayList prod = null;
		String code = null;
		String name = null;
		String color = null;
		int qty = 0;
		
		for(int i = 0; i < list.size(); i++) {
			prod = (Product_ArrayList) list.get(i);
			code = prod.getCode();
			name = prod.getName();
			color = prod.getColor();
			qty = prod.getQty();
			
			System.out.println("제품번호 = " + code);
			System.out.println("제품이름 = " + name);
			System.out.println("제품색상 = " + color);
			System.out.println("제품수량 = " + qty);
		}
	}
	public static void main(String[] args) {
		ArrayList pList = new ArrayList();
		Product_ArrayList p1 = new Product_ArrayList();
		Product_ArrayList p2 = new Product_ArrayList("0002", "스마트TV", "흰색", 200);
		Product_ArrayList p3 = new Product_ArrayList("0003", "노트북", "은색", 200);
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		
		ProductTest_ArrayList p = new ProductTest_ArrayList();
		p.getProductTest_Set(pList);

		
	}

}
