package prac1014;

public class GenericMethodTest {

	public static void main(String[] args) {
		Integer[] iArray = {10,20,30,40,50};
		Double[] dArray = {1.1,1.2,1.3,1.4,1.5};
		Character[] cArray = {'K', 'O', 'R', 'E', 'A'};
		
		printArray(iArray);
		printArray(dArray);
		printArray(cArray);

	}
	//���ʸ��� ����Ͽ� �迭�� ����ϴ� printArray()�޼ҵ�
	// � �ڷ������� ������ ���� 
	
	public static <T> void printArray (T[] array) {
		for(T element : array) {
			//for (T element : i) �̷��� ������ָ�
			//�ڵ����� �迭�� ũ�⸸ŭ for���� �����ݴϴ�
			System.out.printf("%s " , element);
		}
		/*
		 * ū ����ǥ "" �ȿ��� (���ڿ��ȿ���) �ڿ��ִ� ����
		 * '%s'�� ��ġ�� ����� �ϰڴٴ� ���Դϴ�.
		 * ������ ���� '%d' �Ǽ��� '%f' ����� �ֽ��ϴ�.
		 */
		System.out.println();
	}

}
