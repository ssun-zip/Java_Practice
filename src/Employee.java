
public class Employee {
	private String name;
	private double salary;
	
	private static int count = 0; //정적 변수 
	
	// 생성자
	public Employee(String n, double s) {
		name = n;
		salary = s;
		count++; //정적 변수인 count를 증가
		
	}
	//객체가 소멸될때 호출된다
	protected void finalized() {
		count--; //직원이 하나 줄어드는 것이므로 count를 하나 감소
	}
	
	//정적 메소드
	public static int getCount() {
		return count;
	}

}

// output: 현재 직원의 수는: 3
