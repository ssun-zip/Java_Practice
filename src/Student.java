// 2020.09.28
// 생성자 오버로딩(여러개 선언): 수와 타입이 다르다면 여러개의 생성자 선언 가능
// 연습예제

public class Student {

	private int number;
	private String name;
	private int age;
	
	Student(){
		number = 100;
		name = "New Student";
		age = 18;
	}
	
	Student(int num, String name, int age){
		this.number = num; //객체 자신에 대한 reference
		this.name = name;
		this.age = age;	
	}
	// num 은 매개변수에 있는 int num
	// this.number 은 속해있는 class Student의 private int number
	// 객체 자신에 대한 reference 
	
	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		//default값
		Student stu1 = new Student();
		// 새로운 생성자
		Student stu2 = new Student(111, "Kim", 25);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());


	}

}
