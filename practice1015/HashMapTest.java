package practice1015;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		Map map = new HashMap();//HashMap():(Ű��(�ߺ�����),������)�� ����
		map.put(1, new Integer(100));//(1,100)
		map.put("second", "Hello World");//(second,Hello World)
		map.put("third", new MyStudent_Set());//(third,�̸��� �̼��� ,���̴� 23�� �Դϴ�.)
		map.put("fourth", null);//(fourth,null)
		// Integer i = map.get(1);
		Integer i = (Integer) map.get(1);//Ű��1�� 100�� ������
		// String str = map.get("second");
		String str = (String) map.get("second");//Ű��second�� Hello World������
		System.out.println(i);
		System.out.println(str);

		MyStudent_Set st = (MyStudent_Set) map.get("third");//Ű��third�� �̸��� ~~������
		System.out.println(st);
		System.out.println(map.get("third"));//Ű��third�� �̸��� ~~���
		System.out.println(map.get("fourth"));//Ű��fourth�� null�� ���
	}
}


