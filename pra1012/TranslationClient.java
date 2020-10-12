package pra1012;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//�ҽ��� �Է��ϰ� Ctrl+Shift+O�� ������ �ʿ��� ������ �����Ѵ�. 

//ȭ�� ���÷��̿� �̺�Ʈ �߻� 
public class TranslationClient extends JFrame implements ActionListener {

	private BufferedReader in;
	private PrintWriter out;
	private JTextField field;
	private JTextArea area;

	public TranslationClient() throws Exception, IOException {
		
		//ȭ�����
		setTitle("Ŭ���̾�Ʈ");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// �ؽ�Ʈ �Է�ȭ�� 
		field = new JTextField(50);
		field.addActionListener(this);
		
		//���ȭ�� 
		area = new JTextArea(10, 50);

		area.setEditable(false);
		// �Է�ȭ���� �����ٰ� ��ġ�ϰ�
		// ���ȭ���� �� �߾ӿ��ٰ� ��ġ
		add(field, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		
		//���Ϻҷ����� 
		Socket socket = new Socket("localhost", 9101);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		
		// textarea�� input���
		area.append(in.readLine() + "\n");
		area.append(in.readLine() + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// textfield�� ���� �ܾ ������ ���� ���� 
		out.println(field.getText());
		String response = null;
		try {
			response = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		area.append(response + "\n");
	}

	public static void main(String[] args) throws Exception {
		TranslationClient client = new TranslationClient();
	}

}