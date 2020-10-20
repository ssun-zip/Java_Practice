package pac201020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//������ ���������� �Է¹޾� ���Ͽ� �����ϴ� ����
public class ScoreWrite {
	public static void main(String[] args) {
		int count = 1;//�� �� �Է��ߴ����� ī���� �ϴ� ����
		String scoreData = "";
		String s = null;
		File file = new File("ScoreData.txt");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(new FileWriter(file, false));
			//false �� �����,true�� ���� �����

			do {
				System.out.println(count + "��° ������ �Է��ϼ���");
				s = in.readLine();
				if (isRealNumber(s)) {//�Է��� �����Ͱ� ���������� üũ
					if (count != 10) {
						scoreData += s + " , ";
					} else {
						scoreData += s;
					}
					count++;
				} else {
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			} while (count <= 10);

			out.println(scoreData);
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("IOException");
		}
		System.out.println("���������� ���Ϸ� ����մϴ�.");
	}

	//�Է� ���� �����Ͱ� �������� üũ�ϴ� �޼ҵ�
	public static boolean isRealNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

