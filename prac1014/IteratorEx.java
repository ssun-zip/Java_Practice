package prac1014;

import java.util.*;

public class IteratorEx {

	public static void main(String[] args) {
		//�������� �ٷ�� ���׸� ���� ����
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100);
		
		//iterator�̿� ��� ���� ����ϱ�
		// iterator ��ü ���
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			System.out.println(n);
		}
		
		//��� ���� ���ϱ�
		int sum = 0;
		it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			sum += n;
		}
		System.out.println("���Ϳ� �ִ� ���� ��: " + sum);
	}

}
