package prac1014;

import java.util.*;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		list.add(1, "APPLE");//(0-MILK,1-BREAD,2-BUTTER)�ε���1�� "APPLE"�߰�
							//(0-MILK,1-APPLE,2-BREAD,3-BUTTER)
		list.set(2, "GRAPE");//(0-MILK,1-APPLE,2-BREAD,3-BUTTER)
							//�ε���2(2-BREAD)��"GRAPE"�� ��ü
							//(0-MILK,1-APPLE,2-GRAPE,3-BUTTER)
		list.remove(3);//(0-MILK,1-APPLE,2-GRAPE,3-BUTTER)�ε���3�� ����

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
/*<< ArrayList Ŭ������ �⺻���� ��� ��� >>
 - ArrayList Ŭ������ ����Ʈ�� ����� ���ؼ��� ���� ����Ʈ�� ������ �������� Ÿ���� ���ؾ� �մϴ�.
ArrayList Ŭ������ ������ ��� �ڷᱸ�� Ŭ�������� ���۷��� Ÿ���� �����͸� ������ �� �ֽ��ϴ�.
 �ٽ� ���� Ÿ�� �Ķ���͸� ������Ƽ�� Ÿ������ ���ϸ� �� �˴ϴ�.

 - add �޼ҵ�
�����͸� �߰��Ҽ� �ֽ��ϴ�. ȣ��� ������� �����Ͱ� ����˴ϴ�.

 - get�޼ҵ�
 ����Ʈ�� �ִ� �����͸� ������ �� �ֽ��ϴ�. �� �� �Ķ���ͷδ� �������� �ε����� �Ѱ��־�� �մϴ�.
�׷��� �� get �޼ҵ�� �������� ���� ������ �Ѿ �ε����� �Ѱ��ָ� 
IndexOutOfBoundsException�� �߻��մϴ�.
�׷��Ƿ� size �޼ҵ带 ����Ͽ� ����Ʈ�� �ִ� �������� ���� �̸� �˾ƾ� �մϴ�.

<< ArrayList�� �����͸� ����/����/�����ϴ� ��� >>
'set' �޼ҵ� - �����͸� ��ü
'remove' �޼ҵ� - �����͸� ����

<< ArrayList�� �ִ� �����͸� �˻��ϴ� ��� >>
'indexOf' �޼ҵ� - �˻��� �����Ϳ� �Ȱ��� ���� �����͸� �Ķ���ͷ� �Ѱ��ָ� 
					����Ʈ���� �Ȱ��� ���� ���� ù ��° �����͸� ã���ش�.
'lastIndexOf' �޼ҵ� - �˻��� �����Ϳ� �Ȱ��� ���� �����͸� �Ķ���ͷ� �Ѱ��ָ�
 						����Ʈ���� �Ȱ��� ���� ���� ������ �����͸� ã���ش�.
*/
