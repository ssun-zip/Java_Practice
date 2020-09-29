package practice_0929;

//Person.java
//Upcasting.java
//Downcasting.java
public class Person {
	String name;
	String id;
	
	public Person (String name) {
		this.name = name;
	}
}

class Student extends Person {
	String grade;
	String department;
	
	public Student(String name) {
		super(name);
	}
}
