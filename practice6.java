import java.util.*;
import java.util.Calendar; // util 패키지 안의 캘린더 
import myproject1.Weekday; // 다른 패키지의 enumeration import

// 2020.09.24
// 연습 예제들

public class practice6 {
	//상수 열거 타입 선언
	// public enum Week {MONDAY, TUESDAY, WEDNESDAY, 
	//  				THURSDAY, FRIDAY, SATURDAY, SUNDAY};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		arrayLength(scan);
		forEachNames();
		forEachExercise();
		enumWeekExample();
		seqSearch(scan);
		theaterReservation(scan);
		anonymousArray();
		sortExample();
		moneyLeft();
		arratTest6();
		scoreAvrage();
		ticTacToe(scan);
		divideByZero(scan);
		divideByZeroTry(scan);
		numberFornmatException();
	}
	
	// 배열의 length필드 이용하여 배열 크기만큼의 정수를 입력 받고 평균을 구하는 프로그램 작성
	public static void arrayLength(Scanner scan) {
		int intArray[] = new int[5]; //배열의 선언과 생성
		int sum = 0;
		
		System.out.print(intArray.length + "개의 정수를 입력하세요 >>");

		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = scan.nextInt();//입력받운 정수저장
		}
			
		// 배열에 저장된 정수 값을 더학기
		for(int i = 0; i < intArray.length; i++) {
			sum += intArray[i];
		}
			
		System.out.println("평균은:" + (double)sum / intArray.length);
	}
	
	// for-each문으로 나열하여 순차적으로 접근 
	// 과일 이름 나열하기
	public static void forEachNames() {
		String names[] = {"사과", "배", "바나나", "체리", "딸기"};
		for(String s : names) {
			System.out.print(s  + " ");
		}
		System.out.println();
	}
	
	//for-each문으로 나열하여 순차적으로 접근 
	// String 어레이 이용하여 과일, 합, 요일 나열
	public static void forEachExercise() {
		int[] n = {1,2,3,4,5};
		String names[] = {"사과", "배", "바나나", "체리", "딸기", "포도"};
		
		int sum = 0;
		// 아래 for-each에서 k는 n[0] ,n[1] ....
		for(int k : n) {
			System.out.print(k  + " ");
			 sum += k;
		}
		System.out.println("합은" + sum);
		
		// 아래 for-each에서 s는 names[0] , names[1] ...
		for(String s : names) {
			System.out.print(s  + " ");
		}
		System.out.println();
		
		// 아래 for-each에서 day는 월화수목금토일 값으로 반복
		for(Week day : Week.values()) {
			System.out.print(day  + "요일 ");
		}
		System.out.println();
	}
	
	//Enumeration이용 날짜 출력
	public static void enumWeekExample() {
		Weekday today = null; //열거 타입 변수 선언
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week){
			case 1:
				today = Weekday.SUNDAY;
				break;
			case 2:
				today = Weekday.MONDAY;
				break;
			case 3:
				today = Weekday.TUESDAY;
				break;
			case 4:
				today =  Weekday.WEDNESDAY;
				break;
			case 5:
				today= Weekday.THURSDAY;
				break;
			case 6:
				today = Weekday.FRIDAY;
				break;
			case 7:
				today = Weekday.SATURDAY;
				break;
		}
		
		System.out.println("오늘 요일: " + today);
		
		if(today == Weekday.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부를 합니다.");
		}
		
		
	}
	/*
	 * QQ> 다른 패키지에 있는 Week.java를 쓰기.
	 *     import myproject1.Weekday; // 다른 패키지의 enumeration import
	*/
	
	//순차 탐색 
	public static void seqSearch(Scanner scan) {
		int s[] = {0,10,20,30,40,50,60,70,80,90,100};
		int value, index = -1;
		
		System.out.print("탐색할 값을 입력하시오: ");
		value = scan.nextInt();
		
		for(int i = 0; i < s.length; i++) {
			if(s[i] == value) {
				index = i;
			}
		}
		if (index < s.length && index >= 0) {
			System.out.println("" + value + "값은" + index + "위치에 있습니다.");
		}
	}
	
	// 난수를 이용하여 6개의 랜덤한 숫자를 뽑아내기.
	public static void rollDice() {
		final int SIZE = 6;
		int freq[] = new int[SIZE];
		
		for(int i = 0; i < 10000; i++) {
			++freq[(int) (Math.random() * SIZE)];
		}
		System.out.println("=================");
		System.out.println("면빈도");
		System.out.println("=================");
		
		for(int i = 0; i < SIZE; i++) {
			System.out.println("" + (i+1) + "\t" + freq[i]);
		}
	}
	
	// 영화관에서 좌석을 예약하는 프로그램
	public static void theaterReservation(Scanner scan) {
		final int size = 10;
		int[] seats = new int[size];
		while(true) {
			System.out.println("--------------------------------------");
			for(int i = 0; i< size; i++) {
				System.out.print( i+1 + " ");
			}
			System.out.println("\n--------------------------------------");
			for(int i = 0; i< size; i++) {
				System.out.print( seats[i] + " ");
				
				//seat[0] > 배열의 자리가 0부터 시작하기때문에
				//그 첫번째 자리의 값은 [0]으로 찾아야한다.
			}
			System.out.println("\n--------------------------------------");
			System.out.print("원하는 좌석번호를 입력하세요(종료는 -1): ");
			int s = scan.nextInt();
			
			// -1을 입력하였을때 종료 출력
			if(s == -1) {
				System.out.println("종료되었습니다.");
				break;
				
			}
			
			// 자리는 1 부터 시작하지만 배열은 0부터 시작하기때문에 
			// 입력한 자리 -1을 해줘야 배열의 실제 숫자가 나온다
			if(seats[s-1] == 0) {
				seats[s-1] = 1;
				System.out.println("예약되었습니다.");
			} else{
				System.out.println("이미 예약된 자리입니다.");
			}
			System.out.println();
		}
	}
	
	//무명 배열 예제
	public static void anonymousArray() {
		//무명 배열이 생성되어 sum()으로 전달 
		System.out.println("숫자들의 합: " + sum(new int[] {1,2,3,4}));
	}
	
	// int numbers 는 출력하는 sum에 다한 무명배열의 값
	// 상시 바뀔수있다는 특징을 가지고 있음. 
	// anonymousArray() 메소드에서 배열의 숫자들을 받아 합계를 계산하는 메소드.
	public static int sum(int[] numbers) {
		int total = 0;
		for(int i = 0; i < numbers.length; i++) {
			total = total + numbers[i];
		}
		return total;
	}
	
	/*
	   output : one two three
	   run configuration > 으로 one two three를 적는다. 
	   > program argument 에 실행 argument를 입력하고 설정한 후 run.
	   > run config program: -h one two three 입력시
	   >           아웃풋으로 : -h one two three HELP 가 나온다
	public static void commandLine() {
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				System.out.print(" " + args[i]);
			}
			if(args[0].equals("-h")) {
				System.out.print(" HELP ");
			}
		}
	}
	*/

	// import java.util.Arrays;
	// 랜덤한 값을 나열한후 정렬한 리스트 생성하기
	public static void sortExample() {
		final int SIZE = 10;
		int[]  numbers = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			int r = (int)(Math.random() * 100);
			numbers[i] = r;
		}
		//원래의 리스트 나열
		System.out.print("최초의 리스트: ");
		for(int r: numbers) {
			System.out.print(r + " ");
		}
		//리스트 정렬
		Arrays.sort(numbers);
		
		//정렬한 리스트 출력
		System.out.print("\n정렬된 리스트: ");
		for(int r: numbers) {
			System.out.print(r + " ");
		}
	}
	
	// 돈의 단위를 큰것부터 작은거 순서대로 몇개에 
	// 동전으로 그 가격을 이룰수있는지를 구하기.
	public static void moneyLeft() {
		int money = 2680;
		int[] unit = {500,100,50,10};
		for(int i = 0; i < unit.length; i++) {
			int cnt = money / unit[i];
			System.out.println(unit[i] + "원 짜리: " + cnt + "개");
			money %= unit[i]; // money = money % unit[i]
			System.out.println("계산식 " + (money %= 500));
		}
	}
	
	//각 행 각열의 값을 나타내 주는 프로그램
	public static void arratTest6(){
		int[][] array = {
			{10,20,30,40},
			{50,60,70,80},
			{90,100,110,120}
		};
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.println(i + "행 " + j + "열 :" + array[i][j]);
			}
		}	
	}
	
	
	// 전학년 1학기 2학기 점수를 받아 4년 전체 학점의 평균을 구하는 프로그램. 
	public static void scoreAvrage() {
		double score[][] = {{3.3, 3.4}, {3.5, 3.6}, {3.7, 4.0}, {4.2, 4.2}};
		double sum = 0;
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
			}
		}
		
		int n = score.length;
		int m = score[0].length;
		System.out.println("4년 전체 평점 평균은: " + sum/(n*m));
	}
	
	
	//틱택톡 게임
	// QQ. java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3 수정하기.
	//char [][] board = new char[4][4];
	public static void ticTacToe(Scanner scan) {
		char [][] board = new char[4][4];
		int x,y;
		
		//비어있는 보드 만들기 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
			
		do {
			for(int i = 0; i < 3; i++) {
				System.out.println("  " + board[i][0] + "|  "  + board[i][1] + "|  " +
									board[i][2]);
				if(i !=2) {
					System.out.println("---|---|---");
				}
			}
				
			// X수를 놓을 좌표를 입력 
			System.out.print("다음수의 좌표를 입력하시오(0-2): ");
			x = scan.nextInt();
			y = scan.nextInt();
			
			// 위치가 비어있지 않는다면 잘못된 위치이고
			// 아무것도 없다면 X수를 놓는다/
			if(board[x][y] != ' ') {
				System.out.println("잘못된 위치입니다. ");
				continue;
			} else {
				board[x][y] = 'X';
			}
				
			int i = 0, j = 0;
			for( i = 0; i < 3; i++) {
				for (j = 0; j < 3; j++) {
					if(board[i][j] == ' ') {
						break;
					}
				}
				if(board[i][j] == ' ') {
					break;
				}
			}
			if(i < 3 && j < 3) {
				board[i][j] = 'O';
			} 
			
			System.out.println();
		} while(true);	
	}
	
	//ArithmeticException(String s) : 
	//Constructs an ArithmeticException with the specified detail message.
	public static void divideByZero(Scanner scan) {
		int dividend;
		int divisor;
		
		System.out.print("나뉨수를 입력하시오: ");
		dividend = scan.nextInt();
		System.out.print("나눗수를 입력하시오: ");
		divisor = scan.nextInt();
		System.out.println(dividend+ "을 " + divisor + "로 나누면 " +(float) dividend/divisor + "입니다");
	}
	
	//try-catch-finally를 이용하여 0으로 나눠질수없음을 나타내기
	public static void divideByZeroTry(Scanner scan) {
		int dividend;
		int divisor;
		
		while(true) {
			System.out.print("나뉨수를 입력하시오: ");
			dividend = scan.nextInt();
			System.out.print("나눗수를 입력하시오: ");
			divisor = scan.nextInt();
			
			try {
				System.out.println(dividend+ "을 " + divisor + "로 나누면 " + dividend/divisor + "입니다");
				break;
			} catch (ArithmeticException e) { //예외 처리 코드
				System.out.println("0 으로 나눌수없습니다! 다시 입력하세요");
				System.out.println();
			}
		}
	}
	
	// (String/ Integer) 다른 타입인것들을 이용할때 뜨는 에러
	public static void numberFornmatException() {
		try {
			int num = Integer.parseInt("abc");
			System.out.println(num);
		} catch (NumberFormatException e) {
			// 타입이 다른 것을 출력하려고 할때
			System.out.println("NumberFormat 예외 발생");
		}
	}
	//정상으로 돌리기 위해??
	/*
	 * String num = Integer.parseInt("abc");
		System.out.println(num);
		
		**parseInt() > string으로된 숫자 ex, "1234" to integer 변환
	 */
		
}
