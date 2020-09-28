
public class AnimalTest {
	public static void main(String[] agrs) {
		Lion lion = new Lion();
		Animal animal = new Animal();
		Eagle eagle = new Eagle();
		
		animal.eat();
		animal.sleep();
		lion.roar();
		animal.eat();
		animal.sleep();
		eagle.fly();
	}
}
