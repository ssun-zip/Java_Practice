// 2020.09.28
// 정적 변수 연습 예제

public class Car {
	private String model;
	private String color;
	private int speed;
	
	//자동차의 시리얼 번호
	private int id;
	private static int numbers = 0;
	
	public Car(String m, String c, int s) {
		model = m;
		color = c;
		speed = s;
		//자동차의 개수를 증가하고 id에 대입한다
		id = ++numbers;
	}

	public static void main(String[] args) {
		Car c1 = new Car("S600" , "white", 80);
		Car c2 = new Car("E500" , "blue", 20);
		Car c3 = new Car("E500" , "blue", 30);
		int n = Car.numbers;
		System.out.println("지금까지 생성된 자동차의 수  = " + n);
	}
}

// output: 지금까지 생성된 자동차의 수  = 2

/*
	정적 변수가 3이 나오려면 
	ex. 지금까지 생성된 자동차의 수  = 3
	--> 자동차의 개수를 증가시킨다. 
*/