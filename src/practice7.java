// 2020.09.25
// 연습예제들
// class --> Account.java, Car.java, Math.java, MyCounter.java
//           MyMath.java, SafeArray.java, Sample.java, Television.java

import java.util.*;

public class practice7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		inputException(scan);
		televisionTest();
		mathTest();
		televisionTest01();
		carTest();
		myMath();
		stringTest();
		checkString(scan);
		accessEX();
		accountTest();
		safeArrayTest();
		MyCounter();
		
	}

	/*
	 * 세 정수를 입력하여 합을 구하는 프로그램 만약 사용자가 숫자가 다른 타입을 입력한다면 InputMismatchException 에외 발생
	 * 다시 가능한 숫자를 물어보는 형태.
	 */
	public static void inputException(Scanner scan) {
		System.out.println("정수 3개를 입력하시오: ");
		int sum = 0, n = 0;
		for (int i = 0; i < 3; i++) {
			System.out.print(i + ">> ");
			try {
				// 정수 입력
				// 사용자가 문자를 입력하면 InputMismatchException 예외 발생
				n = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시입력하세요!");
				scan.next(); // 입력 스트림에 있는 정수가 아닌 토큰을 버린다.
				// 해당 입력한 문자는 포함시키지않기때문에
				// 이미증가한 i를 감소시키며 포함시키지않음을 업데이트
				i--; // 인덱스가 증가하지 않도록 미리 감소
				continue; // 다음 루프
			}
			sum += n;
		}
		System.out.println("합은 " + sum);
		System.out.println();
	}

	public static void televisionTest() {
		// 객체를 생성한다
		Television tv = new Television();
		// 같은 파일 Television.java 클래스 생성하여 필드 생성

		/* Television.java 연공하는 과정 같은 package > new class
		    public class Television { // 상태 속성 필드; OOP형태 televisionTest() 참조 
			   int channel; 
			   int volume; 
			   boolean onOff; }
		*/

		// 객체의 맴버에 접근할 때는 멤버 연산자 ()를 사용한다
		tv.channel = 7; //tv가 창조하는 객체로부터 && channel이라는 필드에 접근
		tv.volume = 10;
		tv.onOff = true;
		
		//tv와 yourtv는 다른거지만 같은 class를 공유
		Television yourtv = new Television();
		yourtv.channel = 9; 
		yourtv.volume = 12;
		yourtv.onOff = true;
		
		//각 개체마다 별도의 변수를 가진다는 점입니다
		//tv의 정보를 이용하여 작성
		System.out.println("텔레비전의 채널은 " + tv.channel + "이고 볼륨은 " + tv.volume + " 입니다.");
		//yourtv의 정보를 이용하여 작성
		System.out.println("너의 텔레비전의 채널은 " + yourtv.channel + "이고 볼륨은 " + yourtv.volume + " 입니다.");
		System.out.println();
	}
	
	// parameter 와 argument 이용 
	// Math.java 클래스에 있는 parameter의 메소드를 이용하여 main메소드의 인수를 구함. 
	public static void mathTest() {
		int sum;
		// Math.java 클래스 객체 생성
		Math obj = new Math();
		//Math.java 의 return x+y
		sum = obj.add(2, 3);
		System.out.println("2와 3의 합은 " + sum);
		sum = obj.add(7, 8);
		System.out.println("7와 8의 합은 " + sum);
		System.out.println();
	}
	
	//Television.java 클래스 이용
	public static void televisionTest01() {
		Television tv =  new Television();
		//tv.setChannel(11);
		/*
			output: 
			채널은 7이고 볼륨은 9입니다. 
			현재의 채널은 7입니다.
		*/
		tv.setChannel(7);
		tv.volume = 9;
		tv.print();
		System.out.println("현재의 채널은 " + tv.channel + "입니다.");
	}
	
	//Car.java클래스 이용
	public static void carTest() {
		Car myCar = new Car(); 
		myCar.color  = "red";
		myCar.speed = 20;
		myCar.gear = 1;
		//Car [color=red, speed=20, gear=1]
		//System.out.println(myCar)까지만 써도됨.
		// 왜냐하면 Car.java클래스는 하나밖에 return하지않기 때문에
		System.out.println(myCar.toString());
		
		myCar.color = "black";
		myCar.speedDown();
		//Car [color=black, speed=10, gear=1]
		System.out.println(myCar.toString());
		
		myCar.speedDown();
		myCar.changeGear(2);
		//Car [color=black, speed=0, gear=2]
		System.out.println(myCar.toString());
	}
	
	// 정수와 소수로 된 숫자들의 square 구하기
	public static void myMath() {
		MyMath obj = new MyMath();
		System.out.println(obj.square(10));
		System.out.println(obj.square(3.14));
	}
	
	//string을 이용한 결합, 교환, 부분추출, 대문자
	public static void stringTest() {
		String proverb = "A barking dog";
		String s1, s2, s3,s4; //참조 변수로서 메소드에서 반환된 참조값을 받는다. 
		
		System.out.println("문자열의 길이 = " + proverb.length());
		
		s1 = proverb.concat( " never Bites!");  //문자열 결합
		s2 = proverb.replace('B', 'b');         //문자 교환
		s3 = proverb.substring(2,5);            // 문자 부분 추출
		s4 = proverb.toUpperCase();             //대문자로 변환
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
	
	//사용자가 문자열을 받아서 문자열이 "www"로 시작하는 지확인하고
	//quit이라고 적으면 끝난다
	public static void checkString(Scanner scan) {
		String str;
		while(true) {
			System.out.print("문자열을 입력하세요> ");
			str = scan.next();
			if(str.equals("quit") == true) {
				break;
			} else if (str.matches("^www\\.(.+)")) {
				//^www\ = 문자열이 www\로 시작합니다
				// (.+) = 괄호안의 아무런 단어 (문자 반복가능)들의 그룹
				System.out.println(str + "은 'www'로 시작합니다");
			} else {
				System.out.println(str + "은 'www'로 시작하지 않습니다");
			}
		}
	}
	
	// private로 Sample.java가 parameter을 지정해놓으면 에러가 뜨는 이유?
	public static void accessEX() {
		Sample s = new Sample();
		s.a =10;
		s.b =10;
		s.c =10;
	}
		/*
		 Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		 
		 Sample.java 에서 private 을 public 으로 변경 / protected, default 가능
		 
		 */
	
	// Account.java 
	// private parameter에도 설정자가 출력되는이유
	public static void accountTest() {
		Account obj = new Account();
		obj.setName("Tom");
		obj.setBalance(10000000);
		//private parameter 이여도 결과가 출력된이유는
		// 바로 그 private parameter값으로 대입한것이 아니라
		// private한 겂울 this.name으로 다시 받아
		// 그 값으로 name을 리턴했기 때문이다. 
		System.out.println("이름은 " + obj.getName() + " 통장 잔고는 " + obj.getBalance() + "입니다");
	}
	
	// array 0-1-2 (length:3)
	public static void safeArrayTest() {
		SafeArray array = new SafeArray(3);
		
		for(int i = 0; i < array.length; i++) {
			array.put(i,  i * 10);
		}
	}
	
	public static void MyCounter() {
		MyCounter obj1 = new MyCounter(100);
		MyCounter obj2 = new MyCounter(200);
		System.out.println("객체 1의 counter = " + obj1.counter);
		System.out.println("객체 2의 counter = " + obj2.counter);
		
		// obj1 의 counter = 1 이고
		// obj2의 counter = 1
		// 같은 class를 불러오지만 연관된 작동을 하지않기때문에
		// 똑같은 값이 나온다.
	}

}
