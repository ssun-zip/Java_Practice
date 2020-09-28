// 부모 클래스 ColorPointEx
// 자식 클래스: point.java & colorPoint.java 

class ColorPoint extends Point{
	private String color;
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint() {
		System.out.print(color);
		showPoint(); // point 클래스의 showPoint 호출
	}
}