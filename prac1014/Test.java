package prac1014;
import java.util.*;
public class Test {

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
