package Practice_1006;

public class MainClassLambda {

	public static void main(String[] args) {
		LambdaInterface1 li1 = (String s1, String s2, String s3) -> {
			System.out.println( s1 + " " + s2 + " " + s3);
		};
		li1.method("Hello", "java", "World");
		System.out.println();
		
		// LambdaInterface2  --> public void method(String s1);
		
		LambdaInterface2 li2 = (String s1) -> {
			System.out.println(s1);
		};
		li2.method("Hello");
		
		// 실행문이 1개일떼, '{}'를 생략할수있다. 
		LambdaInterface2 li3 = (s1) -> System.out.println(s1);
		li3.method("Hello");

		// 매개변수와 실행문이 1개일 때, '()'와 '{}'를 생략할 수 있다.
		LambdaInterface2 li4 = s1 -> System.out.println(s1);
		li4.method("Hello");
		
		// LambdaInterface3 --> 선언만 되고 실현이 없다. 
		// 매개변수가 없을때, '()'만 작성한다.
		LambdaInterface3 li5 = () -> System.out.println("no parameter");
		li5.method();

		// LambdaInterface4 -->  int method(int x, int y)
		// 반환값이 있는경우
		LambdaInterface4 li6 = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.printf("li6.method(10, 20): %d\n", li6.method(10, 20));
		
		li6 = (x, y) -> {
		    int result = x * y;
		    return result;
		};
		System.out.printf("li6.method(10, 20) : %d\n", li6.method(10, 20));

		li6 = (x, y) -> {
		    int result = x - y;
		    return result;
		};
		System.out.printf("li6.method(10, 20) : %d\n", li6.method(10, 20));
	}

}
