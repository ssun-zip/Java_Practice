
public class SportsCarTest {
	public static void main(String args[]) {
		SportsCar obj = new SportsCar();   // 자식 클래스 객체 생성
		obj.speed = 10;    //부모 클래스의 필드와 메소드 사용
		obj.setSpeed(60);
		obj.setTurbo(true); // 자체 메소드 사용
	}
}
