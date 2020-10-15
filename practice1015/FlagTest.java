package practice1015;

public class FlagTest {
	public static void main(String[] args) {
		White white = new White();
		Blue blue = new Blue();
		//white 먼저 실행되서 백기 올려민 반복실행 
		white.whiteFlag();
		blue.blueFlag();
	}
}
