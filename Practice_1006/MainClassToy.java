package Practice_1006;

public class MainClassToy {

	public static void main(String[] args) {
		Toy robot = new ToyRobot();
		Toy airplane = new ToyAirplane();
		
		/*
		robot.walk();
		robot.run();
		robot.alarm();
		robot.light();
		System.out.println();
		
		airplane.walk();
		airplane.run();
		airplane.alarm();
		airplane.light();
		*/
		
		Toy toys[] = {robot, airplane};
		
		for(int i = 0; i < toys.length; i++) {
			toys[i].walk();
			toys[i].run();
			toys[i].alarm();
			toys[i].light();
			System.out.println();
		}
		
	}

}
