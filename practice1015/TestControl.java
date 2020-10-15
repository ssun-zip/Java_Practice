package practice1015;

public class TestControl {

	static void print(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n",  threadName, message);
	}
	/*
	 * System.out.format�� printf() �Լ��� �����Ҽ��ֽ��ϴ�.
	 * �ڹ� 1.5(=5.0) �̻󿡼��� ��� �����մϴ�
	 * �̰��� System.out.println���� ����ϸ�
	 * ���������� printf�Լ��� ���� ������ �ϰ� �˴ϴ�
	 * %s ū����ǥ ���ڿ�
	 *  %d -10���� 
	 *  %c- ���� ������
	 *   %f- �Ǽ�
	 */
	
	// ���� ���� Ŭ������ �ܺ� Ŭ���� ��ü�� ��� ��� ���� 
	private static class MessageLoop implements Runnable {
		public void run() {
			String message[] = {"Pride will have a fall.", "Power is dangerous unless you have humility"
							, "Office changes manners.", "Empty vessels make the most sound"};
			
			try {
				for( int i = 0; i < message.length; i++) {
					print(message[i]);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				print("���� ������ �ʾҾ��!");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		int tries = 0;
		print("�߰����� �����带 �����մϴ�");
		Thread t = new Thread(new MessageLoop());
		t.start();
		print("�߰����� �����尡 �����⸦ ��ٸ��ϴ�");
		
		while(t.isAlive()) {
			print("���� ��ٸ��ϴ�");
			t.join(1000);
			tries++;
			if(tries > 2) {
				print("������ ���׿�!");
				// ������ t�� ������ �ߴ��մϴ�.
				t.interrupt();
				// ���Ḧ ��ٸ��� �ϴ� �޼ҵ� 
				t.join();
			}
		}
		print("���ν����� ����!");
	}

}
