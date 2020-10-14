package prac1014;

import java.util.*;

public class HashMapDic {

	public static void main(String[] args) {
		//���� �ܾ�� �ѱ� �ܾ���� �����ϴ� HashMap �÷��� ���� 
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "�Ʊ�");
		dic.put("love", "���");
		dic.put("apple", "���");
		
		//dic�÷��ǿ� ����ִ� ��� (key, value) �� ��� 
		Set<String> keys = dic.keySet();
		// ksy���ڿ��� ���� set���� 
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			System.out.println("(" + key + "," + value + ")" );
		}
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			System.out.print("ã�� ���� �ܾ�? ");
			String eng = scan.next();
			System.out.println(dic.get(eng));
		}
	}

}
