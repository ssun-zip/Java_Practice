// 2020.09.28
// 생성자 class와 main method를 분리해야하는것이 원칙이지만
// 같은 class안에서 실행시키는 연습. 

public class Circle {
	int radius;
	String name;
	
	public Circle() {
		radius = 1;
		name = "";
	}
	
	public Circle (int radius) {
		this.radius = radius;
	}
	
	public Circle (int r, String n) {
		radius = r;
		name = n;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		Circle pizza = new Circle(10, "자바피자");
		
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		
		Circle donut = new Circle();
		donut.name = "도넛피자";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);


	}

}

/*
 * Output:
 * 자바피자의 면적은 314.0
	도넛피자의 면적은 3.14
*/

