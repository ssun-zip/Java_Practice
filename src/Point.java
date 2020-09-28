// 부모 클래스 ColorPointEx
// 자식 클래스: point.java & colorPoint.java 

public class Point {
	private int x,y;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("(" + x + ", " + y + ")");
	}
	
}
