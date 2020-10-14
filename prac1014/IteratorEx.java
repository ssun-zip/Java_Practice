package prac1014;

import java.util.*;

public class IteratorEx {

	public static void main(String[] args) {
		//정수값만 다루는 제네릭 백터 생성
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100);
		
		//iterator이용 모든 정수 출력하기
		// iterator 객체 얻기
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			System.out.println(n);
		}
		
		//모든 정수 더하기
		int sum = 0;
		it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			sum += n;
		}
		System.out.println("벡터에 있는 정수 합: " + sum);
	}

}
