package practice_0929;

// 상속자 : Shape.java
// 동적 바인딩 (실행시간 다향성 실현 - 오버로딩은 컴파일 타임 다향성 실현)
public class Circle extends Shape {
	/*
	 * 동적 바인딩
	 * 
	 * @Override public void draw() { System.out.println("Circle"); }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * Shape b = new Circle(); b.paint(); }
	 */

	// 정적 바인딩
	protected String name;

	@Override
	public void draw() {
		name = "Circle";
		super.name = "Shape";
		super.draw();
		System.out.println(name);

	}

	public static void main(String[] args) {

		Shape b = new Circle();
		b.paint();
	}
}
