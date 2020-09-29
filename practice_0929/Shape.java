package practice_0929;


public class Shape {
	protected String name;

	public void paint() {
		draw();
	}
/* 동적 바인딩
	public void draw() {
		System.out.println("Shape");
	}

	public static void main(String[] args) {

		Shape a = new Shape();
		a.paint();
	}
	*/
	
	//정적 바인딩
	public void draw() {
		System.out.println(name);
	}
}

