// ManagerTest.java <-- Employee.java && Manager.java


package practice_0929;

public class Manager extends Employee{
	private int bonus;
	
	public Manager(String name, String address, int salary, int rrn, int bonus) {
		super(name, address, salary, rrn);
		this.bonus =bonus;
	}
	
	void test() {
		System.out.println("names = " + name);
		System.out.println("address = " + address);
		System.out.println("salary = " + salary);
		//자식 클래스에서 부모 클래스의 private필드는 접근할수 없다
		//System.out.println("rrn = " + rrn);
		
	}
}
