// 2020.09.28
// 연습 예제들
public class Sep_28 {

	public static void main(String[] args) {
		myCounter();
		televisionTest();
		boxTest();
		boxTest1();

	}
	
	public static void myCounter() {
		MyCounter obj1 = new MyCounter(3);
		MyCounter obj2 = new MyCounter(6);
		System.out.println("객체 1 의 counter = " + obj1.counter);
		System.out.println("객체 2 의 counter = " + obj2.counter);
	}
	
	public static void televisionTest() {
		Television myTv = new Television(7, 10, true);
		myTv.print();
		Television yourTv = new Television(11, 20, true);
		yourTv.print();
	}
	
	public static void boxTest() {
		Box myBox = new Box(20,30,40);
		System.out.println("박스의 부피는 = " + myBox.getVolume() + "입니다.");
	}
	
	public static void boxTest1() {
		
		ObjectBox b = new ObjectBox();
		b.setData("Hello world!");
		//object type을 string 타입으로 변형
		String s = (String)b.getData(); 
		//object로 출력
		System.out.println(b.getData());
		//string으로 출력
		System.out.println(s);
		
		
		// objectBox에 새로운 벨류를 넣어 출력
		b.setData(new Integer(10));
		// object타입을 integer로 형태 변환
		Integer i = (Integer) b.getData(); 
		System.out.println(b.getData());
		System.out.println(i);	
		
	}
	
	/*
	 * 질문:
	 * 1. Box 클래스에서 private object줄만 남기고 실행하면 왜 안되는가?
	 * 	--> private으로 정보은닉을 하였기 때문에 클래스내에서 필드값 설정과 반환 메소드를
	 * 		설정해 주지 않는다면 프로그램이 돌아가지않는다. 
	 *  
	 * 2. source로 getter & setter 자동 생성해서 만들면 안되는 이유?
	 * 
	 *  --> getter/setter 자동 설정시 setData()로 생성이 되는데
	 *  	object 타입을 지정해주어야 출력이 된다. 
	 *  	Data의 format을 모를시 데이터는 다양한 포맷으로 저장될수있고 원하는 포맷으로 
	 *  	변형될수있으나 overload로 인해 --> java.lang.ClassCastException: 
	 *  	String cannot be cast to java.lang.Integer.
	 *  	그러므로 setData(new Integer(10)) 으로 넣어주는 타입을 지정해주어야함.
	 */

}
