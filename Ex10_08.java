/*
 *  2020.09.21
 *  연습 문제: 등록된 유저네임 확인하기
 */

//하나의 문자 입력:System.in.read()
//Enter누를때 까지 키를 입력받고 입력한 결과가 "hanbit"이면 통과하는 프로그램
import java.io.IOException;
// try-catch 사용하여 프로그램 처리시에 어떤 경우 자신이 처리하지않고 자신이 부른
// 곳으로 던지게 되는데 이경우 method에 throw java.io.IOException같이 명시.
//main() method에서는 IOException이 발생할 수도 있는 작업을 할 것이며,
//만약에 발생한다면, 이를 처리하지 않고 main()을 부른(invoke) 곳으로
// 이 에러를 던진다는 의미

public class Ex10_08 {
	public static void main(String[] args) {
		String userName = "hanbit";
		String input = "";
		int key;
		// int System.in.read()인 이유:
		// ASCII code table에 의거하여 인풋을 byte로 읽어드림

		try { //System.in.read()메소드는 try~catch문으로 묶어야한다.
			System.out.print("이름 ==> "); //공백을 처리하면 읽지 못함
			while ((key = System.in.read()) != 13) { 
				// 13아스키 코드->Carriag Return (Enter/커서를 옮긴다)
				// 13번은 바로 다음줄로 이동하는 코드 (제일 처음칸으로)
				// 10 = LF (line feed > 다음줄로)
				input += Character.toString((char) key); 
				// 입력한 키가 아스키코드 13(Enter를 치지 않을경우)이
				// 아닐경우 무한반복
			}
			if (userName.equals(input))
				System.out.println(input + "님 어서오세요~~");
			else
				System.out.println(input + "님 등록이 안되었습니다~~");
		} catch (IOException e) {
			e.printStackTrace();
			//에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
		}
	}
}

/*
  System.in.read()를 입력하면 빨간줄이 생기고 마우스를 가져가면 풍선도움말이 나옴->
  [Surround with try/catch]를 선택->자동으로 try~catch문으로 묶어줌
  
import java.io.IOException;

public class Ex10_09 {
	public static void main(String[] args) {

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/


