package practice_0929;

public class Bank {
	double getInterestRate() {
		return 0.0;
	}
}

/*
 * 메소드 오버라이등으로 부모 클래스의 메소드를 재정의한다. 
*/

class BadBank extends Bank{
	double getInterestRate() {
		return 10.0;
	}
}

class NormalBank extends Bank{
	double getInterestRate() {
		return 5.0;
	}
}

class GoodBank extends Bank{
	double getInterestRate() {
		return 3.0;
	}
}
