package pac201020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ScoreRead {
	public static void main(String[] args) {
		int totalScore = 0;
		int count = 0;
		float average = 0.0f;
		File file = new File("scoreData.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			s = in.readLine();
			if (s != null) {
				System.out.println("��������: " + s);
				StringTokenizer st = new StringTokenizer(s, " , ");
				while (st.hasMoreTokens()) {
					totalScore += Integer.parseInt(st.nextToken());
					count++;
				}
				/**<StringTokenizerŬ����>
				 * ���ڿ��� ������ ������(Delimiter) ������ �����ָ�,
				 * �׷��� ������ ������ ���������� ����ϴ� ����� �����Ѵ�.
				 *  �� ����� �ַ� ������ ���� ������ �Ľ�(Parsing) �ϴ� ��쿡 ���� ������ �ش�.
				 *  �������� �μ��� ��� ���ڿ��� �����ڸ� �����ϰ� �Ǵµ�,
				 *  �ʿ��� ��� ���� ������ �����ڸ� �����ϴ� �͵� �����ϴ�.
				 *  <hasMoreTokens �޼���>
				 *  ��ȯ�� ��ū(���ڿ��� ���� ���ؿ� ���� �и��� ���� ��� ����)��
				 *  �����ִ����� �˻��Ͽ� boolean ���� ��ȯ�ϴ� �޼����
				 *  while �ݺ����� �ݺ���Ű�� �������� ��Ҵ�.
				 *  <nextToken �޼���>
				 *  �ݺ� ���� �� ���� ȣ��Ǵµ�, �μ��� "()"�� �����Ͽ���. 
				 *  �̷��� �μ��� �����ϰ� �Ǹ�, 
				 *  ������ ���� ���� �ܿ� �� �ٸ� ���� ���ڷ� �νĵǾ� ��ū ������ ������ �Ǹ�,
				 *  ������� �� �� �ֵ��� �ƹ��͵� ������ �ʴ´�.*/
				System.out.println("����: " + totalScore);
				System.out.println("���� �� ���: " + count + " ��");

				average = (float) totalScore / count;
				System.out.println("���� ���: "+average);
			}
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
