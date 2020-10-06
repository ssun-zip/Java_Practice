package Practice_1006;

public class ToyRobot implements Toy{
	@Override
	public void walk() {
		System.out.println("The robot can not walk.");
	}
	
	@Override
	public void run() {
		System.out.println("The robot can not run.");

	}
	
	@Override
	public void alarm() {
		System.out.println("The robot has alarm function.");

	}
	
	@Override
	public void light() {
		System.out.println("The robot has no light function.");
	}
}
