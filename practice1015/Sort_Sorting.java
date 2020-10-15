package practice1015;

import java.util.*;

public class Sort_Sorting {

	public static void main(String[] args) {
		String[] sample = { "i", "walk", "the", "line"};
		List<String> list = Arrays.asList(sample);
		//asList()메소드를 이용해 배열을 리스트로 변환
		Collections.shuffle(list);
		//collection interface가 가지고 있는 정적메소드인 sort() 호출하여서 정렬을 수횅
		System.out.println(list);
	}

}
