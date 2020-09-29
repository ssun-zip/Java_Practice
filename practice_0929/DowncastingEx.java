package practice_0929;
//Person.java
//Upcasting.java
//Downcasting.java

public class DowncastingEx {

	public static void main(String[] args) {
		Person p = new Student("박선아");
		Student s;
		
		s = (Student) p;
		
		System.out.println(s.name);
		s.grade = "A"; // 오류없음
	}

}
