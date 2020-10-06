package Practice_1006;

public class ToyAirplane implements Toy{
	//Override를 실행을 통해 구현시켜준다. 
	@Override
	public void walk() {
		System.out.println("The airplane can not walk.");
	}
	
	@Override
	public void run() {
		System.out.println("The airplane can not run.");

	}
	
	@Override
	public void alarm() {
		System.out.println("The airplane has alarm function.");

	}
	
	@Override
	public void light() {
		System.out.println("The airplane has no light function.");
	}
}

//interface에서 받으면 interface에있는 모든 메소드 implement하여  override하여 재정의 
