package practice1015;

public class stop {

	public static void main(String[] args) throws InterruptedException{
		int tries = 0;
		System.out.print("�߰����� �����带 �����մϴ�");
		Thread t = new Thread(new MessageLoop());
		t.start();
		System.out.print("�߰����� �����尡 �����⸦ ��ٸ��ϴ�");
		
		while(t.isAlive()) {
			System.out.print("���� ��ٸ��ϴ�");
			t.join(1000);
			tries++;
			if(tries > 2) {
				System.out.print("������ ���׿�!");
				t.interrupt();
				t.join();
			}
		}
		System.out.print("���ν����� ����!");
	}

}
