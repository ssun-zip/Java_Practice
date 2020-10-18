package weekendHomework;

class DeaMon extends Thread {
	public void run() {
		while (true) { //항상 참이기 때문에 무한으로 찍는다.
			System.out.println("안녕~~~");
			try {
				Thread.sleep(1000);//1초 기다림
			} catch (Exception e) {
			}
		}
	}
}

public class DaeMonTest {
	public static void main(String[] args) throws InterruptedException {
		DeaMon dm = new DeaMon();
		dm.setDaemon(true);
		//  데몬 스레드
		//- 다른 스레드의 작업을 돕는 스레드
		//- 동작중인 스레드가 없으면 자동 종료
		//- 임시저장, 가바지컬렉션이 대표적
		//- 생성법은 start()를 호출하기 전에 setDaemon(true)호출
		dm.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(6000);//3초 기다림
		}
	}
}