package weekendHomework;

public class Waiter_BusyWait extends Thread{
	String Waiter;
	Food_BusyWait food;

	public Waiter_BusyWait(String Waiter, Food_BusyWait food) {
		this.Waiter = Waiter;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			food.receiveOder(Waiter);
		}
	}
}
