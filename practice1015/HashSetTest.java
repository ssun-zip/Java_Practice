package practice1015;

import java.util.*;

public class HashSetTest {//Set(����):�������� �ߺ����ȵ�
	public static void main(String[] args) {
		Set set = new HashSet();//�ؽ��� ��ü�� �����Ѵ�
		//Collection �������̽��� ������ �ٸ� Ŭ������ ���������� ��ҷ� ����Ǵ� �����Ͱ�
		//����,����,�Ǽ��� �پ��� ���µ��� ����ɼ� �ְ�, ����� ������ �ڵ����� �����մϴ�.
		set.add("Hello");
		set.add(new Integer(178));
		set.add(new Float(4.56F));
		set.add("Hello");
		set.add(new Integer(178));
		set.add(new MyStudent_Set());
		//Set(Hello,178,4.56,Hello(�ߺ�-���ȵ�),178(�ߺ�),�̸��� �̼���, ���̴� 23�� �Դϴ�.)�߰�
		Object[] obj = set.toArray();
		for (int i = 0; i < set.size(); i++) {
			System.out.println(obj[i]);
		}//set.toArray()->
		//Set�� ������ ���Ե�
		//obj(Hello,178,4.56,�̸��� �̼���, ���̴� 23�� �Դϴ�.)���
		System.out.println(set);
	}//set->toString() {
	//return "�̸��� " + name +" ,���̴� " +age +"�� �Դϴ�.";ȣ��
}