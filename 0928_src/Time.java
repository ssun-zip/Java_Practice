// 2020.09.28
// 생성자 오버로딩(여러개 선언): 수와 타입이 다르다면 여러개의 생성자 선언 가능
// 연습예제 Time 

public class Time {

	private int hour;
	private int minute;
	private int second;

	public Time() {
		this(0, 0, 0);
	}

	public Time(int h, int m, int s) {
		// 조건 연산자
		hour = ((h >= 0 && h < 24) ? h : 0);
		minute = ((m >= 0 && m < 60) ? m : 0);
		second = ((s >= 0 && s < 60) ? s : 0);

	}

	// "시:분:초" 형식으로 출력
	public String toString() {
		// %02d = 두자리 정수로 나타내라
		return String.format("%02d: %02d: %02d", hour, minute, second);
	}

	public static void main(String[] args) {
		Time time = new Time();
		System.out.println("기본 생성자 호출 후 시간: " + time.toString());

		Time time2 = new Time(13, 27, 6);
		System.out.println("두번쨰 생성자 호출 후 시간: " + time2.toString());

		Time time3 = new Time(99, 66, 77);
		System.out.println("올바르지 않은 시간 설정 후 시간: " + time3.toString());

	}

}

/*
 * output: 기본 생성자 호출 후 시간: 00: 00: 00 
 * 두번쨰 생성자 호출 후 시간: 13: 27: 06 
 * 올바르지 않은 시간 설정 후 시간: 00: 00: 00
 */
