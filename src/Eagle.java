// animal class 이용한 자식 클래스 lion & eagle

public class Eagle extends Animal{
	private int wings = 2;
	
	void fly() {
		System.out.println("fly()가 호출되었습니다.");
		this.wings = wings;		
		System.out.println(wings);

	}
	/*
	void wings() {
		this.wings = wings;
		System.out.println(wings);
	}
	*/
}
