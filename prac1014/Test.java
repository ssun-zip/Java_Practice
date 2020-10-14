package prac1014;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		GenericType<CharSequence> gt = new GenericType<>(); // 문자배열
		String[] str = { "야호", "신난다", "수요일 이니까" };
		gt.setType(str);
		gt.print();
		GenericType<Integer> gt2 = new GenericType<>(); // 숫자배열
		Integer[] it = { 3, 24, 67, 234 };
		gt2.setType(it);
		gt2.print();
	}
	

}
