package prac1014;

import java.util.*;
import java.util.Queue;

public class QueueTest {
	//pre: 지정한 타입의 예외가 발생하면 메소드를 호출한 곳으로 되던진다. 
	public static void main(String[] args) throws InterruptedException{
		int time = 10;
		Queue<Integer> q = new LinkedList<Integer>();
		//먼저들어간 데이터가 먼저 나오는 구조
		for(int i = time; i >= 0 ; i--) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			System.out.print(q.remove() + " ");
			//현재의 스레드를 1초간 재운다
			Thread.sleep(1000);
		}
	}

}
