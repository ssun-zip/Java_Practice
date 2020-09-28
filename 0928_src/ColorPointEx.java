// 부모 클래스 ColorPointEx
// 자식 클래스: point.java & colorPoint.java 

public class ColorPointEx {

	public static void main(String[] args) {
		Point p = new Point();
		p.set(1,2);
		p.showPoint();
		
		ColorPoint cp= new ColorPoint();
		cp.set(3,4);
		cp.setColor("red");
		cp.showColorPoint();
	}

}

//output: (1, 2)
//        red(3, 4)