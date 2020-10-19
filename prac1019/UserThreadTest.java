package prac1019;

class UserThread extends Thread{
	private String tName = null;
	long sleepTime = 0;
	
	public UserThread(String name) {
		this.tName = name;
	}
	
	public void run() {
		if(tName.contentEquals("first")) {
			sleepTime = 500;
		} else if(tName.contentEquals("second")) {
			sleepTime = 300;

		}else if(tName.contentEquals("third")) {
			sleepTime = 100;

		}
		System.out.println(tName + "¿Ã " + sleepTime + "∏∏≈≠ sleep...");
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 1; i <= 5; i++) {
			System.out.println(tName);
		}
	}
}
public class UserThreadTest {

	public static void main(String[] args) {
		Thread first = new UserThread("first");
		Thread second = new UserThread("second");
		Thread third = new UserThread("third");
		first.start();
		second.start();
		third.start();
	}

}
