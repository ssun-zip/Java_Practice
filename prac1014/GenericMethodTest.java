package prac1014;

public class GenericMethodTest {

	public static void main(String[] args) {
		Integer[] iArray = {10,20,30,40,50};
		Double[] dArray = {1.1,1.2,1.3,1.4,1.5};
		Character[] cArray = {'K', 'O', 'R', 'E', 'A'};
		
		printArray(iArray);
		printArray(dArray);
		printArray(cArray);

	}
	//제너릭을 사용하여 배열을 출력하는 printArray()메소드
	// 어떤 자료형에도 받을수 있음 
	
	public static <T> void printArray (T[] array) {
		for(T element : array) {
			//for (T element : i) 이렇게 사용해주면
			//자동으로 배열의 크기만큼 for문을 돌려줍니다
			System.out.printf("%s " , element);
		}
		/*
		 * 큰 따옴표 "" 안에서 (문자열안에서) 뒤에있는 값은
		 * '%s'의 위치에 출력을 하겠다는 뜻입니다.
		 * 정수의 경우는 '%d' 실수는 '%f' 등등이 있습니다.
		 */
		System.out.println();
	}

}
