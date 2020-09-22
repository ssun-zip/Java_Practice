import java.util.*;
// 2020.09.22
// 연습 문제들

public class Practice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		switchExample();
		gradeSwitch(scan);
		stringSwitch(scan);
		coffeePrice(scan);
		daysMonth(scan);
		doWhile(scan);
		checkInput(scan);
		doWhileExample();
		greatestCommonDividor(scan);
		sum();
		factorial(scan);
		divisor(scan);
		gugu();
		randomNumber(scan);
		nestedLoop();
		averager(scan);
		continueTest();
	}

	// #1 switch문 이용예제
	public static void switchExample() {
		int number = 2;
		switch(number) {
			case 0:
				System.out.println("없음");
				break;
			case 1:
				System.out.println("일");
				break;
			case 2:
				System.out.println("이");
				break;
			default:
				System.out.println("삼");
				break;
			
		}
		System.out.println();
	}
	
	// #2 성적 -> 학점 (scanner + switch 결합)
	public static void gradeSwitch(Scanner scan) {
		char grade;
		int score, number;

		System.out.print("점수를 입력하시오: ");
		score = scan.nextInt();
		//점수를 첫자리 숫자(십/백)의 숫자로 학점의 범위를 파악한다.  
		number = score / 10; 
		switch(number) {
			// 100-90은 A학점
			case 10:
			case 9:
				grade = 'A';
				break;
			// 80점대는 B학점
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			// 60점 미만은 F
			default:
				grade = 'F';
				break;
		}
		System.out.println("학점: " + grade);
		System.out.println();
	}
	
	//#3 String > int 월의 이름을 영어로받아 숫자로 출력 
	public static void stringSwitch(Scanner scan) {
		String month;
		
		System.out.print("월의 이름을 입력하시오 : ");
		month = scan.next();
		
		int monthNumber;
		// 영어로 작성된 string인 달을 숫자로 변환시킴.
		switch (month) {
			case "january":
				monthNumber = 1;
				break;
			case "february":
				monthNumber = 2;
				break;
			case "march":
				monthNumber = 3;
				break;
			case "april":
				monthNumber = 4;
				break;
			case "may":
				monthNumber = 5;
				break;
			case "june":
				monthNumber = 6;
				break;
			case "july":
				monthNumber = 7;
				break;
			case "august":
				monthNumber = 8;
				break;
			case "september":
				monthNumber = 9;
				break;
			case "october":
				monthNumber = 10;
				break;
			case "november":
				monthNumber = 11;
				break;
			default:
				monthNumber = 12;
				break;
		}
		System.out.println(month + "는 " + monthNumber + "월 입니다.");
		System.out.println();
	}

	
	//#4 switch로 커피 가격 알려주기
	public static void coffeePrice(Scanner scan) {
		boolean orderRepeat = true;
		// 사용자가 커피를 주문하고 싶은 동안 실행
		while(orderRepeat) {
			System.out.print ("어떤 메뉴를 주문하시나요? ");
			String order = scan.next();
			int price = 0;
			switch(order) {
				// case 3개가 같은 경우는 함께
				// 결함하여 실행문장을 한번만 작성한다. 
				case "카페라떼":
				case "카푸치노":
				case "에스프레소":
					price = 3500;
					break;
				case "아메리카노":
					price = 2000;
					break;
				default:
					System.out.println("그런 메뉴는 없습니다.");
					break;
			}
			
			//메뉴의 가격 출력
			if(price != 0) {
				System.out.println(order + "의 가격은  " + price + "원입니다.");
			}
			
			// 재주문 또는 주문이 끝나는 경우
			System.out.print("주문을 또 하시겠습니까?(네/ 아니요): ");
			String orderAgain = scan.next(); 
			if (orderAgain.equals("네")) {
				orderRepeat = true;
			} else {
				orderRepeat = false;
				System.out.println("주문을 종료합니다.");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//#5 한달의 일수 찾기
	public static void daysMonth(Scanner scan) {
		int month;
		int days;
		
		System.out.print("일수를 알고싶은 월을 입력하시오: ");
		month = scan.nextInt();
		
		switch(month) {
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = 29;
				break;
			default:
				days = 31;
				break;
		}
		
		System.out.println(month + "월 안에는 " + days + "일까지 있습니다.");
		System.out.println();
	}
	
	// #6 do-while문 예제
	public static void doWhile(Scanner scan) {
		int i = 10;
		do {
			System.out.println("i의 값은: "+ i);
			i++;
		} while (i < 3);
		System.out.println();
	}

	
	// #7 do-while문 예제 
	public static void checkInput(Scanner scan) {
		int month;
		do {
			System.out.print("올바른 월을 입력하시오(1-12): ");
			month = scan.nextInt();
		} while(month < 1 || month >12); //month의 범위는 1-12 사이
		
		System.out.println("사용자가 입력한 월은 " + month + "입니다.");
		System.out.println();	
	}

	
	// #8 do-while문 예제
	//   output: abcdefghijklmnop...xyz
	public static void doWhileExample() {
		char c = 'a';
		do {
			System.out.print(c);
			c++;
		} while(c <= 'z');  // for(c = 'a'; c <= 'z'; ++c)
		System.out.println("\n");
	}
	
	//#9 최대공약수 구하기
	public static void greatestCommonDividor(Scanner scan){
		int x, y, f;
		System.out.print("두 개의 정수를 입력하시오 (큰수, 작은수): ");
		x = scan.nextInt();
		y = scan.nextInt();
		
		while (y != 0) {
			f = x % y;
			x = y;
			y = f;
			
		}
		System.out.println("최대 공약수는 " + x);
		System.out.println();
		
	}
	
	//#10 for loop의 예제
	public static void forExample1() {
		for(int i = 0; i < 5; i++) {
			System.out.println("i 의 값은: " + i);
		}
		System.out.println();
	}
	
	//#11 합계구하기
	public static void sum(){
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			// sum = sum + i;
			sum += i;
		}
		// printf는 변수의 값을 여러가지 형식으로 변환하여 출력 가능
		// 줄바꿈을 하려면 %n 을 입력해 주어야함
		// %d =  정수 형식으로 출력 (decimal)
		// %f =  소수점 형식으로 출력 (float)
		// %c =  문자형식(char) / %s = 문자열 형식 (string) 
		System.out.printf("1부터 10까지의 점수의 합 = %d. %n", sum);
		System.out.println();
	}
	
	//#12 !(factorial) 구하기
	public static void factorial(Scanner scan) {
		// sum을 0 으로 기록할 경우 곱셈이 계속 0이기 때문에 1로 지정해야함
		// 숫자의 크기를 고려해 int보다는 long을 쓰기
		long sum = 1; 
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();
		for(int i = 1; i <= num; i++) {
			sum = sum * i;
		}
		System.out.printf("%d!은 %d입니다", num, sum);
		System.out.println("\n");
	}

	//#13 약수의 공식
	public static void divisor(Scanner scan) {
		System.out.print("양의 정수를 입력하시오: ");
		int n = scan.nextInt();
		
		System.out.print(n + "의 약수는 다음과 같습니다:");
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				System.out.print(" " + i);
			}
		}
		System.out.println("\n");
		
	}
		
	//#14 구구단 출력하기
	public static void gugu() {
		//1단에서 9단까지 구구단
		//1단을 안보이게 하고싶을때는 int i = 2를 초기값으로 설정하면 됨. 
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.print(i + "*" + j + "=" + i*j);
				System.out.print('\t'); //탭으로 띄어쓰기
			}
			System.out.println(); //각단이 끝나면 다음줄로 넘어가기
		}
	}

	//#15 난수의 합 계산하기
	//    0 부터 99 사이의 난수의 합을 계산하는 프로그램  (난수의 개수는 사용자가 입력)
	public static void randomNumber(Scanner scan) {
		Random generator = new Random();
		System.out.print("난수의 개수: ");
		int count = scan.nextInt();
		int sum = 0;
		for(int i = 1; i <= count; i++) {
			// 0부터 99사이의 랜덤한 정수를 추첨
			int number = generator.nextInt(100);
			sum += number;
		}
		System.out.println("난수 "+ count +"개의 합은 " + sum);
		System.out.println();
	}
	
	/*
	 랜덤 숫자를 쓰면 연속적으로 같은 숫자가 나오지않는데
	 나오게 할수가 있다. > 
	 알고리즘:정수를 합하면 항상 값이 달라지기때문에 
	 		0이나 음수의 수가 0으로 나오기 때문에 연속으로 같은 숫자가 나온다. 
	 		
     방법 1:int number = generator.nextInt(1);
         > range ( 0  inclusive n exclusive )
 
	  // 범위 지정할때 공식: 
	   * int randomNum = rand.nextInt(max - min + 1) + min;
	   * */
	   

	
	//#16 *모양 직사각형 만들기
	public static void nestedLoop() {
		for(int i = 0; i < 5; i++) {
			for(int y = 0; y < 10; y++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println();
	} 
	
	//#17 정수들의 평균 구하기
	public static void averager(Scanner scan) {
		int total = 0;
		int count = 0;
		// 정수가 더해질때마다 그의 평균을 구하기
		while(count < 3) {
			System.out.print("정수를 입력하시오: ");
			int grade = scan.nextInt();
			if(grade < 0) {
				break;
				// break 이후에 밑의 실행문은 생략하고
				// while문 밖으로 나간다. 
			}
			total += grade;
			count++;
			System.out.println("평균은 " + total / count);	
		}	
	}

	
	//#18 continue 문
	public static void continueTest() {
		String s = "no news is good news";
		/*
		int n = s.lastIndexOf('n') + 1;
		마지막으로 쓰인 n 이 17번째 자리에 있으므로
		글자의 수가 처음부터 1이라고 할때
		결과가 17이 나온다.
		*/
		int n = 0;
		for(int i = 0; i < s.length(); i++) {
			//n이 나오는 회수를 센다
			if(s.charAt(i)!= 'n') {
				continue;
				// 다시 for loop돌리기
			}
			//n의 개수를 하나 증가한다.
			n++;		
		}
		n = s.length() - n;
		
		System.out.println("문장에서 발견된 n의 개수 " + n);
	}
	
	//#19 continue 문 공백의 갯수
	public static void continueTest2() {
		String s = "no news is good news";
	
		int n = 0;
		for(int i = 0; i < s.length(); i++) {
			//n이 나오는 회수를 센다
			if(s.charAt(i)!= ' ') {
				continue;
				// 다시 for loop돌리기
			}
			//n의 개수를 하나 증가한다.
			n++;		
		}
		
		System.out.println("문장에서 발견된 공백의 개수 " + n);
	}	
}
