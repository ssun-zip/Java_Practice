package practice1015;

public class MyStudent_Set {
	private String name;
	private int age;
	
	public MyStudent_Set() {
		this("�̼���",23);
	}
	public MyStudent_Set(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;		
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;		
	}
	public void setAge(int age) {
		this.age =age;
	}
	public String toString() {
		return "�̸��� " + name +" ,���̴� " +age +"�� �Դϴ�.";
	}	
}

