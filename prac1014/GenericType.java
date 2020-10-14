package prac1014;

public class GenericType<T> {
	T[] t;

	void setType(T[] t) {
		this.t = t;
	}

	void print() {
		for (T v : t) {
			System.out.println(v);
		}
	}

	public static void main(String[] args) {
		GenericType<CharSequence> gt = new GenericType<>(); // ���ڹ迭
		String[] str = { "��ȣ", "�ų���", "������ �̴ϱ�" };
		gt.setType(str);
		gt.print();
		GenericType<Integer> gt2 = new GenericType<>(); // ���ڹ迭
		Integer[] it = { 3, 24, 67, 234 };
		gt2.setType(it);
		gt2.print();
	}

}

//Exception in thread "main" java.lang.NullPointerException
//void setType(T[] t) { --> T[] n ���� ����� no pointer
