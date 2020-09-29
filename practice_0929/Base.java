package practice_0929;

//기본 생성자 특정 같은 parameter type 을 받는다
class Base{
	public Base() {
		System.out.println("Base()생성자");
	}
}

class Derived extends Base{
	public Derived() {
		System.out.println("Derived()생성자");
	}
}


