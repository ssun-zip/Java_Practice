package practice1015;

/** setPriority()��� */
class Horse02 implements Runnable {
	private int horse_num;
	public static int num=0;	

	public Horse02(int horse_num) {
		this.horse_num = horse_num;	
		
	}

	@Override // Override ����� �޼��� ���θ� ����
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(horse_num + "�� ���� " + 100 * i + "���� ����");
			}			
		
	}
}

public class Horse01 {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Horse02(1));
		Thread t2 = new Thread(new Horse02(2));
		Thread t3 = new Thread(new Horse02(3));
		Thread t4 = new Thread(new Horse02(4));
		Thread t5 = new Thread(new Horse02(5));
		Thread t6 = new Thread(new Horse02(6));
		Thread t7 = new Thread(new Horse02(7));
		Thread t8 = new Thread(new Horse02(8));
		Thread t9 = new Thread(new Horse02(9));

		t1.setPriority(1);//�������� �����췯 �켱�����������һ�
		t2.setPriority(2);//���� ������ �����췯�� �����Ѵ�.
		t3.setPriority(3);
		t4.setPriority(4);
		t5.setPriority(5);
		t6.setPriority(6);
		t7.setPriority(7);
		t8.setPriority(8);
		t9.setPriority(9);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();

		System.out.println("main() ����...");
	}
}
