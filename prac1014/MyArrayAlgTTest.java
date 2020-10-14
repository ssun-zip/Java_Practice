package prac1014;

public class MyArrayAlgTTest {

	public static void main(String[] args) {
		String[] lang = {"C++" , "C#" , "JAVA"};
		//String last = MyArrayAlg.getLast(lang); // last = java
		MyArrayAlg.swap(lang, 1, 2);
		for(String val: lang) {
			System.out.println(val);
		}	
	}
}
