package prac1014;

import java.util.*;
import java.util.Queue;

public class QueueTest {
	//pre: ������ Ÿ���� ���ܰ� �߻��ϸ� �޼ҵ带 ȣ���� ������ �Ǵ�����. 
	public static void main(String[] args) throws InterruptedException{
		int time = 10;
		Queue<Integer> q = new LinkedList<Integer>();
		//������ �����Ͱ� ���� ������ ����
		for(int i = time; i >= 0 ; i--) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			System.out.print(q.remove() + " ");
			//������ �����带 1�ʰ� ����
			Thread.sleep(1000);
		}
	}

}
