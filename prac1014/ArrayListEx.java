package prac1014;

import java.util.*;
//Ű����� ���ڿ��� �Է¹޾� ArrayList�� �����ϰ� ���� �� �̸��� ����϶�

public class ArrayListEx {
	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		//var a = new  new ArrayList<String>(); ���� 
		
		Scanner scan = new Scanner(System.in);
		
		// Ű����� 4���� �̸��� �Է¹޾� ArrayList�� ���� 
		for(int i = 0; i < 4; i++) {
			System.out.print("�̸��� �Է��ϼ���>>");
			String s = scan.next();
			a.add(s); //ArrayList �÷��ǿ� ����
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
		System.out.println("\n ���� �� �̸��� :" + a.get(longestIndex));
	}
}
