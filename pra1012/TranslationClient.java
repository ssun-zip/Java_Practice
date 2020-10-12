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

//소스를 입력하고 Ctrl+Shift+O를 눌러서 필요한 파일을 포함한다. 

//화면 디스플레이와 이벤트 발생 
public class TranslationClient extends JFrame implements ActionListener {

	private BufferedReader in;
	private PrintWriter out;
	private JTextField field;
	private JTextArea area;

	public TranslationClient() throws Exception, IOException {
		
		//화면출력
		setTitle("클라이언트");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 텍스트 입력화면 
		field = new JTextField(50);
		field.addActionListener(this);
		
		//출력화면 
		area = new JTextArea(10, 50);

		area.setEditable(false);
		// 입력화면을 위에다가 배치하고
		// 출력화면을 밑 중앙에다가 배치
		add(field, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		
		//소켓불러오기 
		Socket socket = new Socket("localhost", 9101);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		
		// textarea에 input출력
		area.append(in.readLine() + "\n");
		area.append(in.readLine() + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// textfield에 적은 단어를 소켓을 통해 전송 
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