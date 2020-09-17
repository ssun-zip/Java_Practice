package myproject;
 
// Day 2: 2020.09.17
// 예제 문제들 연습코딩

 public class Hello1 {
	public static void main(String[] args) {
		helloWorld();
		printLightDistance();
		calculateArea();
		booleanTest();
		varInitialTest();
		constant();
		leapYear();
		binaryOperator();
		assignmentIncDecOperator();
		comparisonOperator();
		logicalOperator();
		logicalOperator2();
	}

    //  #1 Hello world 코드 작성
	public static void helloWorld() {
		System.out.println("Hello World!");
		System.out.println("I'm a new Java Programmer.");
		System.out.println();
	}

    //#2 빛이 1년동안 가는 거리를 구하는 공식
	public static void printLightDistance() {
		long lightspeed;
		long distance;
		
		lightspeed = 300000;
		distance = lightspeed *365L * 24 * 60 * 60;
		
		System.out.println("빛이 1년 동안 가는 거리 : " + distance + " km.");
		System.out.println();
	}
	
	//#3 반지름이 5.0인 원의 면적을 계산하는 프로그램 작성
	public static void calculateArea() {
		double radius, area;
		radius = 5.0;
		area = 3.141592 * radius * radius;
		System.out.println("원의 면적은 " + area);
		System.out.println();
	}
	
	//#4 논리형 
	public static void booleanTest() {
		boolean b;
		b = true;
		System.out.println("b : " +	b);
		b = (1>2);
		System.out.println("b : " +	b);
		System.out.println();
	}
	
	// #변수 초기화 오류
	public static void varInitialTest() {
		int index;  // or int index = 12;
		index = 12;  
		index += 1; // 지역변수는 사용하기전 받드시 초기화 시켜야한다. 
		System.out.println("index: " + index);
		System.out.println();
	}
	
	//#6 상수를 만드는 방법
	public static void constant() {
		final double KM_PER_MILE = 1.609344;
		double km;
		double mile = 60.0;
		km = KM_PER_MILE * mile;
		
		System.out.println("60마일은 " + km + " 킬로미터입니다.");
		System.out.println();
	}
	
	//#7 윤달 검사 프로그램
	public static void leapYear() {
		int year = 2012;
		boolean isLeapYear;
		
		isLeapYear = (year % 4 == 0);
		
		System.out.println(isLeapYear);
		System.out.println();
	}
	
	//#8 증감 연산자
	public static void binaryOperator(){
		int x = 1;
		int y = 1;
		
		int nextx = ++x; //x값이 사용전 증가
		int nexty = y++; // y값 사용 후 증가
		System.out.println("x 와 y 의 값이 1 일때");
		System.out.println("++x 은 "+ nextx);
		System.out.println("y++ 은 " + nexty);
		System.out.println();
	}
	
	//#9 대입연산자와 증감연산자 사용
	public static void assignmentIncDecOperator() {
		int a = 3, b = 3, c = 3;
		a += 3;
		b *= 3;
		c %= 2;
		System.out.println("a = "+ a + ", b= " + b + ", c= " +c);
		
		int d = 3;
		a = d++; // a = 3, d = 4
		System.out.println("a = " + a + ", d = "+ d);
		a = ++d; //a = 5, d = 5
		System.out.println("a = " + a + ", d = "+ d);
		a = d--; //a = 5, d = 4
		System.out.println("a = " + a + ", d = "+ d);
		a = --d; //a = 3, d = 3
		System.out.println("a = " + a + ", d = "+ d);
		System.out.println();
		
	}
	
	//#10 관계 연산자 
	public static void comparisonOperator() {
		int x = 3;
		int y = 4;
		
		System.out.print((x == y) + " ");
		System.out.print((x != y) + " ");
		System.out.print((x > y) + " ");
		System.out.print((x < y) + " ");
		System.out.println((x <= y) + " ");
		System.out.println();
	}
	
	//#11 논리연산자
	public static void logicalOperator() {
		int x = 3;
		int y = 4;
		
		System.out.println((x == 3) && (y == 7));
		System.out.println((x == 3 || y == 4));
		System.out.println();
	}
	
	//#12 비교연산자와 논리 연산자 사용하기
	public static void logicalOperator2() {
		//비교연산
		System.out.println('a' > 'b');
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 <= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2);
		System.out.println(!(3 != 2));
		
		//비교연산과 논리연산 복합
		System.out.println((3>2) && (3>4));
		System.out.println((3!= 2) || (-1 > 0));
		System.out.println((3!=2) ^ (-1 > 0));
	}
}

