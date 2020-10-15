package practice1015;

import java.util.*;

public class WordFreq_Map {
	
	//map 중복키를 가질수없다
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		
		for(String a : sample) {
			Integer freq = m.get(a);
			m.put(a,  (freq == null) ? 1 : freq + 1);
			//삼합 연산가 (조건 a, (freq == null) ? 참이면 1실행 거짓이면 freq +1 실행
			//단어를 꺼내서 빈도를 증가시킴
		}
		System.out.println(m.size() + " 단어가 있습니다.");
		System.out.println(m.containsKey("to"));
		System.out.println(m.isEmpty());
		System.out.println(m);

		
	}

}
