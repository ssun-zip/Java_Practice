package prac1014;

public class GenericEx1Main {

	public static void main(String[] args) {
		GenericEx1<String> t = new GenericEx1<String>();
		//genericex1 ��ü ������ ���� �ڷ��� string �� �ڷ��� ���
		String[] ss = {"Ye~" , "Ah~", "Seo"};
		t.set(ss);
		//���ʸ� ǥ������ ���� ������ ����ȯ�� �ʿ䰡 �̾���
		t.print();
	}
		
/*
		GenericEx1 t1 = new GenericEx1(); // ���� ����� �ƴ�
		Integer[] s = {1,2,3};
		t1.set(s);
		t1.print();
*/
}

//Exception in thread "main" java.lang.Error: Unresolved compilation problem
// public class GenericEx1<T> {
// ���� public class GenericEx1<String> { ���κ��� 