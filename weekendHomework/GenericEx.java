package weekendHomework;

import java.util.*;

public class GenericEx {
	static HashMap<String, String> tel;
	static boolean run = true;

	public static void main(String[] args) {
		tel = new HashMap<String, String>();
		phoneBookCreate();
		work(run);
		
	}
	
	public static Boolean work(Boolean run) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			intro();
			Integer task = scan.nextInt();

			if (task == 1) {
				System.out.println("당신의 이름과 연락처를 저장하세요!");
				System.out.print("당신의 이름은? ");
				String name = scan.next();
				System.out.print("당신의 번호 (- 없이 입력하세요)? ");
				String number = scan.next();
				System.out.println();
				tel.put(name, number);
			} else if (task == 2) {
				Set<String> names = tel.keySet();
				Iterator<String> it = names.iterator();
				while (it.hasNext()) {
					String person = it.next();
					String p_number = tel.get(person);
					System.out.println(person + " " + p_number);
					System.out.println();

				}
			} else if (task == 3) {
				System.out.println("찾고싶은 전화번호의 이름을 입력하세요: ");
				String find = scan.next();
				String found = tel.get(find);
				if(found == null) {
					System.out.println("등록된 이름의 번호가 존재하지않습니다.");
				} else {
					System.out.println(find +"님의 번호는 " + found + " 입니다.");
				}
				System.out.println();
			}
			
			System.out.print("모든 작업이 끝났습니까? (y/n): ");
			String stop = scan.next();
			if(stop.equals("y")) {
				return false;
			}
			return true;
		}
	}

	private static void phoneBookCreate() {
		String[] names = {"박선아", "배수지", "강호동", "김수현", "하지원","정수정", "티파니"};
		String[] numbers = {"01011111111", "010112221111", "01044411111", "01055511111", 
				"01011666111", "01017771111", "01011888111"};
		for(int i = 0; i < names.length; i++ ) {
			tel.put(names[i], numbers[i]);
		}

	}

	public static void intro() {
		System.out.println("1. 연락처 저장");
		System.out.println("2. 전화번호부 확인");
		System.out.println("3. 전화번호 찾기");
		System.out.print("하고싶은 작업을 입력하세요: ");
		System.out.println();

	}
}
