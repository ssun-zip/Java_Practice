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
		String[] korText = { "동해물과백 두산이 마르고 닳도록",
				"하느님이 보우하사 우리나라만세",
				"무궁화 삼천리 화려강산",
				"대한사람대한으로 길이보전하세",
				"남산위에 저소나무 철갑을 두른듯",
				//"바람서리 불변함은 우리 기상일세"
				//, "무궁화 삼천리 화려강산",
				//"대한사람 대한으로 길이보전하세"
				};
		
		Thread th1 = new WorkerThread(p, engText);
		Thread th2 = new WorkerThread(p, korText);
		th1.start();
		th2.start();
		}
	}
	class SharedPrinter {
		// 두 workerThread 스레드에 의해 동시 접근되는 공유 프린터
		//synchronized 생략하면
		//한글과 영어가 한줄에 섞여 출력되는 경우 발생 
		synchronized void print(String text) {
			for(int i = 0; i < text.length(); i++) {
				System.out.print(text.charAt(i));
			}
			System.out.println();
		}
	}
	// WorkerThread 클래스 thread 클래스 상속
	class WorkerThread extends Thread{
		//공유 프린터 주소
		SharedPrinter p;
		String[] text;
		WorkerThread(SharedPrinter p, String[] text){
			this.p = p;
			this.text = text;
		}
		
		public void run() {
			//스레드를 반복적으로 공유 프린터에 10번 접근 text[] 출력 
			for(int i = 0; i < text.length; i++) {
				//공유 프린터에 출력 
				p.print(text[i]);
			}
		}

}
