package prac1014;

import java.util.*;

public class HashMapDic {

	public static void main(String[] args) {
		//영어 단어와 한글 단어쌍을 저장하는 HashMap 컬렉션 생성 
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		//dic컬렉션에 들어있는 모든 (key, value) 쌍 출력 
		Set<String> keys = dic.keySet();
		// ksy문자열을 가진 set리턴 
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			System.out.println("(" + key + "," + value + ")" );
		}
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			System.out.print("찾고 싶은 단어? ");
			String eng = scan.next();
			System.out.println(dic.get(eng));
		}
	}

}
