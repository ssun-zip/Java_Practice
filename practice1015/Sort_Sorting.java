package practice1015;

import java.util.*;

public class Sort_Sorting {

	public static void main(String[] args) {
		String[] sample = { "i", "walk", "the", "line"};
		List<String> list = Arrays.asList(sample);
		//asList()�޼ҵ带 �̿��� �迭�� ����Ʈ�� ��ȯ
		Collections.shuffle(list);
		//collection interface�� ������ �ִ� �����޼ҵ��� sort() ȣ���Ͽ��� ������ ��ȷ
		System.out.println(list);
	}

}
