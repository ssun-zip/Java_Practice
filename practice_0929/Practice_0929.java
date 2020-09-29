package practice_0929;

import java.util.Scanner;

public class Practice_0929 {

	public static void main(String[] args) {
		int sum = 0;;
		Scanner sc = new Scanner(System.in);
		System.out.print("5개의 정수를 입력하세요 : ");
		for(int i=0; i<5; i++) {
			int n=sc.nextInt();
			if(n<=0){
				continue;
			}
			sum+=n;
		}
		System.out.println("양수의 합은 " + sum);
	}
}
