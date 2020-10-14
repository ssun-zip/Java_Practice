package prac1014;

import java.util.*;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		list.add(1, "APPLE");//(0-MILK,1-BREAD,2-BUTTER)인덱스1에 "APPLE"추가
							//(0-MILK,1-APPLE,2-BREAD,3-BUTTER)
		list.set(2, "GRAPE");//(0-MILK,1-APPLE,2-BREAD,3-BUTTER)
							//인덱스2(2-BREAD)를"GRAPE"로 대체
							//(0-MILK,1-APPLE,2-GRAPE,3-BUTTER)
		list.remove(3);//(0-MILK,1-APPLE,2-GRAPE,3-BUTTER)인덱스3을 삭제

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
/*<< ArrayList 클래스의 기본적인 사용 방법 >>
 - ArrayList 클래스로 리스트를 만들기 위해서는 먼저 리스트에 저장할 데이터의 타입을 정해야 합니다.
ArrayList 클래스를 포함한 모든 자료구조 클래스에는 레퍼런스 타입의 데이터만 저장할 수 있습니다.
 다시 말해 타입 파라미터를 프리미티브 타입으로 정하면 안 됩니다.

 - add 메소드
데이터를 추가할수 있습니다. 호출된 순서대로 데이터가 저장됩니다.

 - get메소드
 리스트에 있는 데이터를 가져올 수 있습니다. 이 때 파라미터로는 데이터의 인덱스를 넘겨주어야 합니다.
그런데 이 get 메소드는 데이터의 존재 범위를 넘어선 인덱스를 넘겨주면 
IndexOutOfBoundsException을 발생합니다.
그러므로 size 메소드를 사용하여 리스트에 있는 데이터의 수를 미리 알아야 합니다.

<< ArrayList에 데이터를 삽입/수정/삭제하는 방법 >>
'set' 메소드 - 데이터를 교체
'remove' 메소드 - 데이터를 삭제

<< ArrayList에 있는 데이터를 검색하는 방법 >>
'indexOf' 메소드 - 검색할 데이터와 똑같은 값의 데이터를 파라미터로 넘겨주면 
					리스트에서 똑같은 값을 갖는 첫 번째 데이터를 찾아준다.
'lastIndexOf' 메소드 - 검색할 데이터와 똑같은 값의 데이터를 파라미터로 넘겨주면
 						리스트에서 똑같은 값을 갖는 마지막 데이터를 찾아준다.
*/
