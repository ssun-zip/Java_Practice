package prac1014;

import java.util.*;

public class ArrayList_03 {
	public static void main(String[] args) {
		ArrayList < Integer> list1 = new ArrayList<>();
		ArrayList < Integer> list2 = new ArrayList<>();
		ArrayList < Integer> cha = new ArrayList<>();
		ArrayList < Integer> kyo = new ArrayList<>();
		ArrayList < Integer> hap = new ArrayList<>();
		
		Integer[] label = {1,2,3,4};
		Integer[] label2 = {3,4,5,6};
		
		add(list1, label);
		add(list2, label2);
		
		add(cha, label); //.addAll(lsit1)
		cha.removeAll(list2);
		
		hap.addAll(cha);
		add(hap,label2);
		
		add(kyo, label);
		kyo.removeAll(cha);
		
		System.out.println("리스트 1: "+ list1);
		System.out.println("리스트 2: "+ list2);

		System.out.println("교집합: "+ kyo);
		System.out.println("합집합: "+ hap);
		System.out.println("1-2: "+ cha);
		
	}
	
	private static void add(ArrayList<Integer> a1, Integer[] s) {
		for(int i = 0; i < s.length; i++) {
			a1.add(s[i]);
		}
	}
}
