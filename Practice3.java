import java.util.*;
// 2020.09.21
// 연습 예제 문제들 

public class Practice3 {

	public static void main(String[] args) {
		ternaryOperator();
		successOrFail();
		multipleOfThree();
		evenOdd();
		larger();
		bonus();
		grading();
		gradeByYear();
		printHello();
		welcomeLoop();
		loopExample();
		loopExample2();
		claSum();
	}

	//#1 조건 연산
	public static void ternaryOperator() {
		int a = 3, b = 5;
		
		System.out.println("두 수의 차는 " + ((a>b)?(a-b) : (b-a)));
		System.out.println();
		// 두수의 양수 차를 구하기 위해 
		// a가 더 큰수라면 a-b 
		// b가 더 큰 수라면 b-a 를 이용하여 값을 구한다.
		// 풀어쓰게 되면:
		// if (a>b) a-b; else b-a;
	}
	
	//#2 if문 사용하기
	public static void successOrFail() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하시오(100점): ");
		int score = scanner.nextInt();
		if(score >= 80) {
			System.out.println("축하합니다! 합격입니다.");
		} else {
			System.out.println("재평가입니다.");
		}
		System.out.println();
		
	}
	/* 
	<SCANNER.CLOSE()> :
		scanner.close()를 각 메소드마다 이용시, 
		scanner empty이므로 
		java.util.NoSuchElementException()이 뜰수있음.
		그러므로 맨 마지막에 scanner을 끝낼때만 이용해야한다. 
	*/
	
	//#3 if-else 사용하기
	public static void multipleOfThree() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하시오. ");
		int number = scanner.nextInt();
		
		if(number % 3 == 0) {
			System.out.println(number + "은 3의 배수입니다.");
		} else {
			System.out.println(number + "은 3의 배수가 아닙니다.");
		}
		System.out.println();
	}
	
	//#4 홀수 짝수를 구하는 프로그램
	public static void evenOdd() {
		int number;
		Scanner input = new Scanner(System.in);
		System.out.print("정수를 입력하시오: ");
		number = input.nextInt();
		
		if(number % 2 == 0) {
			System.out.println("입력된 수는 짝수입니다.");
		} else {
			System.out.println("입력된 수는 홀수입니다.");
		}
		System.out.println("프로그램이 종료되었습니다.");
		System.out.println();
	}
	
	//#5 두 정수 중 큰수를 구하는 프로그램
	public static void larger() {
		int x, y, max;
		
		Scanner input = new Scanner(System.in);
		System.out.print("첫번쨰 정수: ");
		x = input.nextInt();
		
		System.out.print("두번째 정수: ");
		y = input.nextInt();
		
		if (x>y) {
			max = x;
		} else {
			max = y;
		}
		System.out.println("큰 수는 " + max);
		System.out.println();
	}
	
	//#6 성과급 계산
	public static void bonus() {
		final int targetSale = 1000;
		int mySales;
		int bonus;
		String result;
		
		Scanner input = new Scanner(System.in);
		System.out.print("실적을 입력해 주세요(단위:만원): ");
		mySales = input.nextInt();
		
		if(mySales >= targetSale) {
			result = "실적 달성";
			bonus = (mySales - targetSale) / 10;
		} else {
			result = "실적 달성 못함";
			bonus = 0;
		}
		System.out.println(result + "\n" + "보너스: " + bonus);
		System.out.println();
	}
	
	//#7 다중 if-else문으로 학점 매기기
	public static void grading() {
		char grade;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요: ");
		int score = scan.nextInt();
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >= 70) {
			grade = 'C';
		} else if(score >= 60) {
			grade = 'D';
		} else {
			grade = 'E';
		}

		System.out.println("학점은 " + grade + " 입니다.");
		System.out.println(); 
	}
	
	//#8 점수와 학년 60 <= 합격 else 불합격
	//   4 학년 70 <= 합격
	public static void gradeByYear() {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하세요 (0-100): ");
		int score = scan.nextInt();
		
		System.out.print("학년읋 입력하세요 (1-4): ");
		int year = scan.nextInt();
		
		if(score >= 60) {
			if(year < 4) { // 60점이상 1-3학년
				System.out.println("합격!");
			} else if(score >= 70) { //70점이상 4학년
				System.out.println("합격!");
			} 
		} else {
			System.out.println("불합격!");
		}
		System.out.println();
	}
	
	//#9 랩 인사말 출력
	public static void printHello() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		// deprecation : 사용하지 말아야 할 메서드 관련 경고
		// 용도: 이 메소드는 다음버전에 더 개선된 메소드로 대체될것이기 때문에
		// 이용을 자제해야 한다. 더 나은 기능을 제공하고 있으니, 차선책을 찾아보라는
		// 의미로 쓰인다.
		int currentHour = date.getHours();
		
		System.out.println("현재 시간은 " + date);
		if(currentHour < 11) {
			System.out.println("Good Morning!");
		} else if (currentHour < 15) {
			System.out.println("Good Afternoon!");
		} else if (currentHour < 20) {
			System.out.println("Good Evening!");
		} else {
			System.out.println("Good Night!");
		}
		System.out.println(); 
	}
	
	//#10 welcome while loop
	public static void welcomeLoop() {
		int i = 0;
		// i가 0부터 시작하기 때문에 0-4 (5번 프린트 됨)
		while (i < 5) {
			System.out.println("환영합니다");
			i++;
		}
		System.out.println("반복이 종료되었습니다.");
		System.out.println(); 
	}
	
	//#11 옆으로 while loop통해 숫자나열
	public static void loopExample() {
		int i = 0;
		// 0부터 9까지 숫자 출력
		while (i < 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println("\n"); 
	}

	//#12 구구단 출력
	public static void loopExample2() {
		int n;
		int i = 1;
		System.out.print("구구단 중에서 출력하고 싶은 단을 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		// i 는 그 단을 1부터 9까지 순서대로/차례대로 곱하는 수
		while(i <= 9) {
			System.out.println(n + " * " + i + " = " + n*i);
			i++;
		}
		System.out.println(); 
	}
	
	//#13 합계 계산하기 (1 - 10까지)
	public static void claSum() {
		int i = 1;
		int sum = 0;
		while(i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("합계: " + sum); 
		System.out.println(); 
	}
}
