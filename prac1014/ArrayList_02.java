package prac1014;

import java.util.ArrayList;

public class ArrayList_02 {

	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<>();
		String[] label = {"watermelon", "apple", "banana", "watermelon", "Jujube","banana"};
		add(a1, label);
		System.out.println("Count:" + a1.size());
		print(a1);
		
		a1.add(1, "kiwi");
		print(a1);
		a1.add(4,"peach");
		print(a1);
		// remove index 0 = watermellon
		a1.remove(0);
		print(a1);
		System.out.println("Index 3: " + a1.get(3));
		System.out.println("banana: " + a1.contains("banana"));
		System.out.println("banana: " + a1.indexOf("banana"));
		System.out.println("banana: " + a1.lastIndexOf("banana"));
		
		for(int i  = 0; i < a1.size(); i++) {
			if(a1.get(i).contentEquals("banana")) {
				a1.set(i,  "strawberry");
			}
		}
		print(a1);
	}
	
	private static void add(ArrayList<String> a1, String[] s) {
		for(int i = 0; i < s.length; i++) {
			a1.add(s[i]);
		}
	}
	
	private static void print(ArrayList<String> a1) {
		for(String str: a1) {
			System.out.print(str + "\t");
		}
		System.out.println();
	}	

}
