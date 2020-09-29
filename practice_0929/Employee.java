// ManagerTest.java <-- Employee.java && Manager.java

package practice_0929;

public class Employee {
	public String name;
	String address;
	protected int salary;
	private int rrn; //주민등록번호: private입력
	
	public Employee(String name, String address, int salary, int rrn) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.rrn = rrn;
	}
	
	@Override
	public String toString() {
		return "Employee [name = " + name + ", address = " + address +
				", salary = " + salary + ", rrm = " + rrn + "]";
	}
}
