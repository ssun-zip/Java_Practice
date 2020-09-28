// Cars의 자식 클래스
// 보모: cars.java 자식:sportsCar.java

public class SportsCar extends Cars{
	boolean turbo;
	
	public void setTurbo (boolean flag) { // 터보 모드 설정 메소드 
		turbo = flag;
	}
}
