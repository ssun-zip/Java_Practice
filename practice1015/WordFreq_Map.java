package practice1015;

import java.util.*;

public class WordFreq_Map {
	
	//map �ߺ�Ű�� ����������
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		
		for(String a : sample) {
			Integer freq = m.get(a);
			m.put(a,  (freq == null) ? 1 : freq + 1);
			//���� ���갡 (���� a, (freq == null) ? ���̸� 1���� �����̸� freq +1 ����
			//�ܾ ������ �󵵸� ������Ŵ
		}
		System.out.println(m.size() + " �ܾ �ֽ��ϴ�.");
		System.out.println(m.containsKey("to"));
		System.out.println(m.isEmpty());
		System.out.println(m);

		
	}

}
