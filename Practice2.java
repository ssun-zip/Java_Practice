package myproject;
import java.util.*;

// 2020.09.18
// 연습 예제 문제들 

public class Practice2 {

	public static void main(String[] args) {
		hello();
		typeConversion();
		stringTest();
		grade();
		scannerExample();
	}
	
	// #1 자바프로그램의 기본 구조
	// 예제에서는 main() method에서 실행 시작
	// 이 코드에서는 main() method에 있는 hello()를 호출하여 실행
	public static void hello () {
		//변수 타입과 변수이름 선언
		int i = 20;
		int s;
		char a;
		
		s = sum(i, 10); // sum method 호출하서 그값을 리턴받아옴
		a = '?';
	
		//표준 출력 스크립 system.out의 println() 메소드 호출 
		System.out.println(a);
		System.out.println("Hello");
		System.out.println(s);
		System.out.println();
	}
	
	// 메소드 호출 
	// takes in two integer and return the sum
	public static int sum(int n, int m) {
		return n + m;
	}
	
	//#2 형변환
	public static void typeConversion() {
		int i;
		double f;
		
		// 5/4는 피연산자가 정수이므로 정수로 계산되어 1이 된다.
		// double형 변수로 대입되므로 울릴 변환이 발생하여 1.0이 1에 저장된다
		f = 5 / 4;
		System.out.println(f);
		
		//형변환 연산자가 우선순위가 높기 때문에 먼저 실행되어 5가 부동소수점수 5.0으로 변환
		// double형으로 자동 형변환되어 1.25 결과가 된다
		f = (double) 5/4;
		System.out.println(f);
		
		//(int) + (int)에서는 모두 1로 변환되어 2가 저장된다 
		i = (int)1.3 + (int) 1.8;
		System.out.println(i);
		System.out.println();
	}
	
	//#3 문자열 프로그램
	public static void stringTest() {
		String s1 = "Hello World!";
		String s2 = "I'm a new Java programmer!";
		
		System.out.println(s1 + "\n" + s2); // + 연산자로 문자열 합치기 
		System.out.println();
	}
	
	//#4 사용자로부터 받은 2개의 점수
	//  :두 사용자의 점수를 입력받아 점수의 합계를 출력함.
	public static void grade() {
		Scanner input = new Scanner(System.in);
		int x, y, sum;
		
		// 사용자1이 입력한 점수를 저장
		System.out.print("점수를 입력하세요: ");
		x = input.nextInt();
		
		// 사용자2가 입력한 점수를 저장
		System.out.print("점수를 입력하세요: ");
		y = input.nextInt();
		
		sum = x + y;
		
		System.out.println("점수의 함계: " + sum);
		System.out.println();
	}
	
	//#5 Scanner 를 이용한 키 입력 연습
	public static void scannerExample() {
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.next(); //문장열 읽기
		System.out.print("이름은 " + name + ", ");
		
		String city = scanner.next(); //문장열 읽기
		System.out.print("도시는 " + city + ", ");
		
		int age = scanner.nextInt(); //정수 읽기
		System.out.print("나이는 " + age + ", ");
		
		double weight = scanner.nextDouble(); //실수 읽기
		System.out.print("체중은 " + weight + "kg, ");
		
		boolean single = scanner.nextBoolean(); //논리값 읽기
		System.out.print("독신 여부는 " + single + "입니다.");
		
		scanner.close(); //scanner닫기
	}
}
