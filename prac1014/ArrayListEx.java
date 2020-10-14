package prac1014;

import java.util.*;
//키보드로 문자열을 입력받아 ArrayList에 삽입하고 가장 긴 이름을 출력하라

public class ArrayListEx {
	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		//var a = new  new ArrayList<String>(); 가능 
		
		Scanner scan = new Scanner(System.in);
		
		// 키보드로 4개의 이름을 입력받아 ArrayList에 삽입 
		for(int i = 0; i < 4; i++) {
			System.out.print("이름을 입력하세요>>");
			String s = scan.next();
			a.add(s); //ArrayList 컬렉션에 삽입
		}
		
		for(int i = 0; i < a.size(); i++) {
			String name = a.get(i);
			System.out.print(name + " ");
		}
		
		int longestIndex = 0;
		for(int i = 0; i < a.size(); i++) {
			if(a.get(longestIndex).length() < a.get(i).length()) {
				longestIndex = i;
			}
		}
		System.out.println("\n 가장 긴 이름은 :" + a.get(longestIndex));
	}
}
