package practice1015;

public class TestControl {

	static void print(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n",  threadName, message);
	}
	/*
	 * System.out.format은 printf() 함수를 구현할수있습니다.
	 * 자바 1.5(=5.0) 이상에서만 사용 가능합니다
	 * 이것을 System.out.println으로 출력하면
	 * 최종적으로 printf함수와 같은 역할을 하게 됩니다
	 * %s 큰따옴표 문자열
	 *  %d -10진수 
	 *  %c- 작은 따옴펴
	 *   %f- 실수
	 */
	
	// 정적 내부 클래스는 외부 클래스 객체가 없어도 사용 가능 
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
				print("아직 끝나지 않았어요!");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		int tries = 0;
		print("추가적인 스레드를 시작합니다");
		Thread t = new Thread(new MessageLoop());
		t.start();
		print("추가적인 스레드가 끝나기를 기다립니다");
		
		while(t.isAlive()) {
			print("아직 기다립니다");
			t.join(1000);
			tries++;
			if(tries > 2) {
				print("참을수 없네요!");
				// 스레드 t를 강제로 중단합니다.
				t.interrupt();
				// 종료를 기다리게 하는 메소드 
				t.join();
			}
		}
		print("메인스레드 종료!");
	}

}
