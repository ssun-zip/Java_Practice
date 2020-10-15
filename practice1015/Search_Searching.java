package practice1015;

import java.util.*;

public class Search_Searching {

	public static void main(String[] args) {
		int key = 50;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			list.add(i);
		}
		int index = Collections.binarySearch(list, key);
		//Collections class의 binarySearch algorithm
		// 정렬됟 클래스에서 지정된 원소를 이진 탐색한다
		//binarySearch()은 리스트와 탐색할 원소를 받는다.
		//리스트는 정렬되어 있다고 가정한다.
		
		System.out.println("탐색의 반환값 = " + index);
	}

}
