package prac1014;

public class GenericEx1Main {

	public static void main(String[] args) {
		GenericEx1<String> t = new GenericEx1<String>();
		//genericex1 객체 생성시 가상 자료형 string 의 자료형 명시
		String[] ss = {"Ye~" , "Ah~", "Seo"};
		t.set(ss);
		//제너릭 표현으로 인해 별도의 형변환이 필요가 ㅜ없다
		t.print();
	}
		
/*
		GenericEx1 t1 = new GenericEx1(); // 좋은 방법이 아님
		Integer[] s = {1,2,3};
		t1.set(s);
		t1.print();
*/
}

//Exception in thread "main" java.lang.Error: Unresolved compilation problem
// public class GenericEx1<T> {
// 에서 public class GenericEx1<String> { 으로변경 