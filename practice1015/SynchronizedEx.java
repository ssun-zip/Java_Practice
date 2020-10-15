package practice1015;

public class SynchronizedEx {

	public static void main(String[] args) {
		SharedPrinter p = new SharedPrinter();
		String[] engText = { "wise men say,"
				, "only fools rush in"
				, "But i can't help",
				"falling in love with you",
				"shall i stay?",
				//"would it be a sin?"
				//, "if i can't help",
				//"falling in love with you"
				};
		String[] korText = { "���ع����� �λ��� ������ �⵵��",
				"�ϴ����� �����ϻ� �츮���󸸼�",
				"����ȭ ��õ�� ȭ������",
				"���ѻ���������� ���̺����ϼ�",
				"�������� ���ҳ��� ö���� �θ���",
				//"�ٶ����� �Һ����� �츮 ����ϼ�"
				//, "����ȭ ��õ�� ȭ������",
				//"���ѻ�� �������� ���̺����ϼ�"
				};
		
		Thread th1 = new WorkerThread(p, engText);
		Thread th2 = new WorkerThread(p, korText);
		th1.start();
		th2.start();
		}
	}
	class SharedPrinter {
		// �� workerThread �����忡 ���� ���� ���ٵǴ� ���� ������
		//synchronized �����ϸ�
		//�ѱ۰� ��� ���ٿ� ���� ��µǴ� ��� �߻� 
		synchronized void print(String text) {
			for(int i = 0; i < text.length(); i++) {
				System.out.print(text.charAt(i));
			}
			System.out.println();
		}
	}
	// WorkerThread Ŭ���� thread Ŭ���� ���
	class WorkerThread extends Thread{
		//���� ������ �ּ�
		SharedPrinter p;
		String[] text;
		WorkerThread(SharedPrinter p, String[] text){
			this.p = p;
			this.text = text;
		}
		
		public void run() {
			//�����带 �ݺ������� ���� �����Ϳ� 10�� ���� text[] ��� 
			for(int i = 0; i < text.length; i++) {
				//���� �����Ϳ� ��� 
				p.print(text[i]);
			}
		}

}
