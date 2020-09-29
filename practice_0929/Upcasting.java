package practice_0929;
//Person.java
//Upcasting.java
//Downcasting.java

public class Upcasting{
	public static void main(String[] args) {
		Person p;
		Student s = new Student("박선아");
		p = s;
		
		System.out.println(p.name);
	}
}