package Practice1008;
//HangMan Program

import java.io.*;
import java.util.*;

public class Test {
	static String solution;
	
	// 수정할수 있는 StringBuffer a 와 guessing 한 글자 ch 그리고 정답 s 를 받아들어
	// 정답에 guessing한 글자가 포함되어있는지 확인한다.
	// 만약 포함한다면 true를 리턴하고 같지않다면 false를 리턴한다.
	static boolean check(String s, StringBuffer a, char ch) {
		int i;
		for( i = 0; i < s.length(); i++) {
			//guessing 한 글자가 그 단어/문장에 포함되어있는지 확인
			if(s.charAt(i) == ch) {
				//스트링의 한 문자를 설정한다. 스트링 길이 밖에 있는 인덱스에는 아무 효과 없다.
				// 그 위치에 정답이므로 그 글자로 바꾸어준다.
				a.setCharAt(i,  ch);
			}
		}
		
		for( i = 0; i < s.length(); i++) {
			// 정답에 위치한 각 자리글자와 내가 예상한 단어의 각 자리수가 같지않다면 false로 return
			if(s.charAt(i) != a.charAt(i)) {
				return false; 
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		char ch;
		Scanner sc = new Scanner(System.in);
		BufferedReader in = null;
		String[] words = new String[100];
		int count = 0;
		
		in = new BufferedReader(new FileReader("input.txt"));
		for(int i = 0; i < 100; i++) {
			// 단어말고 문장 (라인)으로 문자열 저장 
			String s = in.readLine();
			if(s==null) {
				break;
			}
			words[i] = s;
			count++;
		}
		// index를 문장들의 숫자중 랜덤하게 고르기 
		int index = (new Random()).nextInt(count);
		
		//해답을 words리스트중 랜덤하게 고른 숫자에 위치한 문장으로 지정 
		solution = words[index];
		// String은 인스턴스가 생성되묜 그값을 읽기만 가능 수정 불가능
		// StringBuffer 클래스의 인스턴스는 그 값을 변경할 수도 있고, 추가
		// answer은 계속 정답일때 마다 수정해야하기때문에 StringBuffer
		StringBuffer answer = new StringBuffer(solution.length());
		
		for(int i = 0; i < solution.length(); i++) {
			// 문장의 길이 만큼을 ' ' 를 answer에 추가
			answer.append(' ');
		}
		
		for(int i = 0; i < solution.length(); i++) {
			if(solution.charAt(i) != ' ') {
				// 정답에 띠어쓰기가 아니고 문자로 지정되어있다면 
				// 각 글자의 위치마다 _ 을 적어주고 몇개의 글자가 남아있는지
				// 사용자가 확인할수있도록 도와준다. 
				answer.setCharAt(i,  '_');
			}
		}
		
		while(true) {
			//정답 
			//System.out.println("현재의 상태:" + solution);
			// 내가 guessing한 정답 
			// 답이 맞을 경우는 그 단어를 위치에 기입하고 아니면 _ 으로 자리수를 알려준다.
			System.out.println("현재의 상태:" + answer);
			System.out.printf("글자를 추측하시오: ");
			String c = sc.next();
			
			// solution 정답과 내가 guessing한 answer이 일치한다면 프로그램을 종료한다.
			if(check(solution, answer, c.charAt(0)) == true) break;

		}
		
		// 프로그램이 다끝났을때 현재의 상태 마지막 final 정답을 출력한다. 
		System.out.println("현재의 상태:" + answer);
		
	}
}
