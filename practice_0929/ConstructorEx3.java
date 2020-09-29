package practice_0929;

public class ConstructorEx3 {

	public static void main(String[] args) {
		B b = new B(5);
	}

}

class A {
	public A() {
		System.out.println("생성자 A");
	}
	public A(int x) {
		System.out.println("매개변수 생성자 A");
	}
}

class B extends A {
	public B() {
		System.out.println("생성자 B");
	}
	public B(int x) {
		System.out.println("매개변수 생성자 B");
	}
}

/*
	질문: 생성자 A 매개변수 생성자 B 출력값이 어떻게 나오는가?
	
	1. B b =  new B(5)
	2. public B(5) ==> class B extends A
	3. class A --> public A() 출력
	4. public B(5) 출력
	-끝-
	
	하위 클래스가 호출될 때 자동으로 상위 클래스의 기본 생성자를 호출하게 된다
	
*/ 