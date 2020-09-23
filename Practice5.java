// 2020.09.23
// 연습 문제들

import java.util.*;

public class Practice5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		guessingGame(scan);
		forExample();
		whileSample(scan);
		simulateDie();
		exitPrint(scan);
		equals();
		generateLotteryNumber();
		reverseString(scan);
		generateNumber(scan);
		generateStudentInfo(scan);
		arrayTest();
		arrayTest2(scan);
		arr01();
		pizzaTopping();
		arr03();
		getMin();
		maxTest();

	}

	// #1 숫자 추측 게임
	public static void guessingGame(Scanner scan) {
		int guess = 0;
		int answer = 59;
		int tries = 0;
		do {
			System.out.print("정수를 추측하여 보시오: ");
			guess = scan.nextInt();
			tries++;

			if (guess > answer) {
				System.out.println("제시한 정수가 높습니다.");
			} else if (guess < answer) {
				System.out.println("제시한 정수가 낮습니다.");
			} else {
				System.out.println("축하합니다. 시도횟수: " + tries);
			}

		} while (guess != answer);
	}

	// #2 for loop으로 공식 출력하고 sum 구하기
	public static void forExample() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i; // sum = sum + i;
			System.out.print(i);
			;

			if (i <= 9) { // i 가 1-9까지 + 출력
				System.out.print("+"); // + 출력
			} else {
				System.out.print("="); // = 출력
				System.out.print(sum); // 덧셈 출력 결과
			}
		}
		System.out.println();
	}

	// #3 정수의 개수와 평균 구하기
	public static void whileSample(Scanner scan) {
		int count = 0;
		int sum = 0;
		System.out.print("정수를 입력하고 마지막에 -1을 입력하세요.");

		int n = scan.nextInt();
		// -1 : 문장의 끝 ;; -1입력되면 while문 벗어남
		while (n != -1) { // 입력한 숫자가 -1이 아닐 동안 프로그램 진행
			sum += n;
			count++;
			n = scan.nextInt(); // 정수입력
		}

		if (count == 0) {
			System.out.println("입력된 수가 없습니다.");
		} else {
			System.out.print("정수의 개수는 " + count + "개이며 ");
			System.out.println("평균은 " + (double) sum / count + " 입니다.");
		}
	}

	// #4 랜덤한 숫자 구하기 (난수 예제)
	public static void simulateDie() {
		Random rand = new Random();
		int randNumber;
		// 범위가 1-6 까지이기 때문에 난수 7이 나올수 없다.
		randNumber = rand.nextInt(6) + 1;
		;
		System.out.println("난수 " + randNumber);

		/*
		 * 문제: 난수가 7이 나오게하려면? int nextInt(int num) => 0부터 num-1까지 범위에 있는 난수 반환 1.
		 * rand.nextInt(7) + 1; 2. rand.nextInt(6) + 2; 3. rand.nextInt();
		 */
	}

	// #5 while문 사용 "exit" 입력시 종료 끝
	public static void exitPrint(Scanner scan) {
		String answer = "";
		while (!answer.equals("exit")) {
			System.out.print("나가시겠습니까? (exit / no): ");
			answer = scan.next();
		}
		/*
		 * while(true){ System.out.println(">>"); String answer = scan.nextLine();
		 * if(answer.equals("exit")) break; }
		 */
		System.out.println("종료 끝.");
	}

	// #6 Equals string reference vs. literal
	public static void equals() {
		String str1 = new String("같다"); // string reference
		String str2 = "같다"; // string literal
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		/*
		 * string literal과 string reference 주가지 string에서 메모리 할당 방식의 차이가 있다 두개 모두 java
		 * heap memory에 저장된다. 근데 java heap memory에는 string pool이 존재하는데, string은 java에서
		 * 한번 선언하면 변하지않기 때문에 string pool이 존재한다
		 * 
		 * String pool이란? 리터럴 상수로 string을 생성한 방법에서 str이 string pool에 저장된다. 그리고 이 string
		 * pool에서는 생성된 문자열이 그 후에 같은 문자열이 생성될 경우 새로운 공간을 내주는 것이 아니라, string pool에 존재하는 값을
		 * 가리키도록 하고 없을 경우 새로운 공간을 내준다. 그렇기 때문에 같은 리터럴 문자열은 == 과 equals()와 같이 모두 true 이다.
		 * 
		 * string reference의 객체 생성 선언은 같은 문자열을 갖도록 선언하여도 다른 객체를 가리키기 때문에 연산자 == 와 결과는
		 * false, equals()의 결과는 true가 나온다
		 */
	}

	// #7
	public static void generateLotteryNumber() {
		int number1, number2, number3, number4, number5, number6;

		Random rand = new Random();

		// 1 -45사이 (0제외)된 수의 범위
		number1 = rand.nextInt(45) + 1;
		number2 = rand.nextInt(45) + 1;
		number3 = rand.nextInt(45) + 1;
		number4 = rand.nextInt(45) + 1;
		number5 = rand.nextInt(45) + 1;
		number6 = rand.nextInt(45) + 1;

		// 6개의 복권 번호들을 차례대로 출력한다.
		System.out.println("생성된 복권번호1: " + number1);
		System.out.println("생성된 복권번호2: " + number2);
		System.out.println("생성된 복권번호3: " + number3);
		System.out.println("생성된 복권번호4: " + number4);
		System.out.println("생성된 복권번호5: " + number5);
		System.out.println("생성된 복권번호6: " + number6);

	}
	/*
	 * 복권 난수들중 중복되는 숫자가 나올수있다. 왜나하면 각자 다르게 rand.nextInt()를 매번 새로 불러 숫자를 추출했기 때문. 만약
	 * 중복되는 숫자를 원하지않을경우 for/while loop으로 돌려 한번만 불러주어야한다.
	 * 
	 */

	// #19 맨뒤의 두자리만 바꾸고 나머지는 같은 문자열로 나열
	// 길이 3 일 경우엔 문자가 순서가 역전됨. ex. 하이루 -> 루이하
	// 입력: 가나다라마바
	// 출력: 마바가나다라
	public static void reverseString(Scanner scan) {
		String str; // 입력받는 문자열
		int length; // 문자열 길이
		// int index; 지수
		char ch; // 마지막 문자
		String rest;// 남은 문자열
		String outputSt = ""; // 출력 문자열

		// 문자열을 입력받는다.
		System.out.print("길이가 3인 문자열을 입력하세요: ");
		str = scan.next();

		// 입력 문자열을 출력한다
		System.out.println("입력 문자열: " + str);

		// 문자열의 길이를 구한다
		length = str.length();

		// 마지막 문자를 끄집어 낸다
		ch = str.charAt(length - 1);

		// 마지막 문자를 제고한 후 남은 문자열을 rest가 가리키게 한다
		rest = str.substring(0, length - 1);

		// 끄집어 낸 문자를 출력 문자열의 끝에 추가한다
		outputSt = outputSt + ch; // output= "바"

		// 남은 문자열의 마지막 길이를 구한다
		length = rest.length();

		// 남은 문자열의 마지막 문자를 끄집어 낸다
		ch = rest.charAt(length - 1); // ch = 마

		// 마지막 문자를 제거한 후 남은 문자열을 rest가 가리키게 한다
		rest = rest.substring(0, length - 1); // rest = 가나다라

		// 끄집어 낸 문자를 출력 문자열의 끝에 추가한다
		outputSt = outputSt + ch; // outputSt = 바마

		// 남은 문자열을 출력 문자열의 끝에 추가한다
		outputSt = outputSt + rest; // outputSt = 바마가나다라

		System.out.println("출력 문자열: " + outputSt);
	}

	/*
	 * 문제
	 * 
	 * 신입생에게 임의의 학번을 부여하는 프로그램을 작성하라. 신입생으로부터 이름과 생년월일을 입력 받은 후 임의의 학번을 생성하고 이름,
	 * 생년월일과 학번을 출력해야 한다. 생년월일은 yyyy/mm/dd의 형태로 입력해야 한다. yyyy는 연도를 나타낸다. mm은 월을 나타내고
	 * 1월부터 9월까지는 한 자리 숫자이고 10월부터 12월까지는 두 자리 숫자이다. dd는 일을 나타내고 1일부터 9일까지는 한 자리 숫자이고
	 * 10일부터 31일까지는 두 자리 숫자이다. 학번은 17로 시작하고 17XXXX의 형태를 취한다. 학번의 XXXX는 1000부터
	 * 1009까지의 정수여야 한다.
	 */
	public static void generateNumber(Scanner scan) {
		String name;
		String birthdate;
		String year;
		String month;
		String day;
		int number;
		int index;
		String rest; //남은 문자열
		
		// 1. 이름을 입력받는다
		System.out.print("이름을 입력하시오: ");
		name = scan.next();
		//2. 생년월일을 입력 받는다.
		System.out.print("생년월일을 입력하시오(yyyy/mm/dd): ");
		birthdate = scan.next();
		
		//3. 생년월일에서 연도를 끄집어 낸다
		year = birthdate.substring(0,4);
		// 4. 생년월일에서 연도와 '/'를 삭제한 후 남은 문자열을 rest가 가리키게 한다.
		rest = birthdate.substring(5);
		//5. 남은 문자열에서 '/'가 나오는 첫 번째 지수를 찾는다.
		index = rest.indexOf("/");
		// 6. 남은 문자열에서 월을 끄집어 낸다.
		month = rest.substring(0, index);
		// 7. 남은 문자열에서 '/'을 삭제한 후 남은 문자열을 rest를 끄집어 낸다.
		day = rest.substring(index+1);
		
		/*
		year = birthdate.substring(0,4);
		month = birthdate.substring(5,7);
		day = birthdate.substring(8,10);
		*/
		
		//8. 1000부터 1009까지의 임의의 번호를 생성한다.
		Random rand = new Random();
		// nextInt(n) > 0포함 n 불포함 
		number = rand.nextInt(10) + 1000;
		
		//9. 17로 시작하는 6자리 학번을 만든다.
		number = 170000 + number;
		
		//10. 이름, 생년월일, 학번을 출력한다
		System.out.println("이름: " + name);
		System.out.println("생년월일: " + year+ "년 " + month + "월 " + day + "일");
		System.out.println("학번: " + number);
	}
	
	// 학생의 이름, 학번, 학과 정보 출력하기
	public static void generateStudentInfo(Scanner scan) {
		String input;
		String name;
		String number;
		int index;
		String department;
		String rest;
		
		System.out.print("이름, 학번과 학과를 입력하세요 (이름/학번/학과): ");
		input = scan.next();
		
		index = input.indexOf("/");
		name = input.substring(0, index);
		rest = input.substring(index + 1);
		index = rest.indexOf("/");
		number = rest.substring(0, index);
		department = rest.substring(index+1);
		
		
		System.out.println("이름: " + name);
		System.out.println("학번: " + number);
		System.out.println("학과: " + department);
	}
	
	// 반복문
	public static void arrayTest() {
		int[] s = new int[10];
		for(int i = 0; i < s.length; i++) {
			s[i] = i;
		}
		for(int i = 0; i < s.length; i++){
			System.out.print(s[i] + " ");
		}
	} 
	
	// LAB성적의 평균 구하기
	public static void arrayTest2(Scanner scan) {
		final int STUDENT = 5;
		int total = 0;
		
		int[] score = new int[STUDENT];
		
		for(int i = 0; i < score.length; i++) {
			System.out.print("성적을 입력하시오: ");
			score[i] = scan.nextInt();
		}
		
		for(int i = 0 ;i < score.length; i++){
				total += score[i];
		}
		System.out.println("평균 성적은" + total/STUDENT + " 입니다.");
	}
	
	//arrayIndex 나열하기
	public static void arr01() {
		//Error: ArrayIndexOutOfBoundException()
		//Index 5 out of bounds for length 5
		// 범위값을 벗어나 에러 출력
		int[] a= new int[6];
		a[0] = 7;
		a[1] = 34;
		a[2] = 67;
		a[3] = 6;
		a[4] = 234;
		a[5] = 5; // indexOutOfBound Exception new int[5] 
		System.out.println("배열의 갯수: " + a.length);
		for(int i = 0; i < a.length; i++) {
			//배열명, 베열의 개수
			System.out.println("a[" + i + "] = " + a[i]);
		}	
	}
	
	//피자토핑 배열 나열
	public static void pizzaTopping() {
		String[] toppings = {"Peppernoni" , "Mushroom" , "Onions" , 
								"Sausage" , "Bacon"};
		for(int i = 0; i < toppings.length; i++) {
			System.out.print(toppings[i] + " ");
		}
	}
	
	//토끼 나열을 for loop 두가지 형태로 출력
	public static void arr03() {
		String[] str = {"산토끼", "집토끼", "판토끼", "죽은토끼", "알카리토끼"};
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		System.out.println("------------------");
		for(String k1: str) {
			System.out.println(k1);
		}
	}
	
	//최소값 알고리즘 : 최소값 구할때 일단 배열의 첫번쨰 요소를 최소값으로 가정
	public static void getMin() {
		int s[] = {12,3,19,6,18,8,12,4,1,19};
		int minimum;
		
		minimum = s[0];
		
		for(int i = 1; i < s.length; i++) {
			if(s[i] < minimum) {
				minimum = s[i];
			}
		}
		System.out.print("최소값은 " + minimum);
	}
	
	// max, mean, average구하기
	public static void maxTest() {
		int[] num = {76,45,34,89,100,50,90,92};
		int sum = 0, max = 0, min = 120;
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
			if(num[i] > max) max = num[i];
			if(num[i] < min) min = num[i];
		}
		System.out.println("합계: " + sum);
		System.out.println("평균: " + sum/num.length);
		System.out.println("최대: " + max);
		System.out.println("최소: " + min);
	}

}
