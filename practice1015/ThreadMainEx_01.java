package practice1015;

public class ThreadMainEx_01 {

	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("������ ������ �̸�  = " + name);
		System.out.println("������ ������ ID  = " + id);
		System.out.println("������ ������ �켱���� ��  = " + priority);
		System.out.println("������ ������ ����  = " + s);

	}

}
