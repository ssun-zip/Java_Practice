package practice1015;

public class stop {

	public static void main(String[] args) throws InterruptedException{
		int tries = 0;
		System.out.print("추가적인 스레드를 시작합니다");
		Thread t = new Thread(new MessageLoop());
		t.start();
		System.out.print("추가적인 스레드가 끝나기를 기다립니다");
		
		while(t.isAlive()) {
			System.out.print("아직 기다립니다");
			t.join(1000);
			tries++;
			if(tries > 2) {
				System.out.print("참을수 없네요!");
				t.interrupt();
				t.join();
			}
		}
		System.out.print("메인스레드 종료!");
	}

}
