package practice1013;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClinetExample extends Application {
	Socket socket;

	public static void main(String[] args) {
		launch(args);// Application ����
	}

	TextArea txtDisplay;// �޼��� ��°�ü
	TextField txtInput;// �޼��� �Է°�ü
	Button btnConn, btnSend;// ��ư
	//ȭ�� ���� ����

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);// ��500,����300

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);// �޼��� ���â ��������
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));// ��������
		root.setCenter(txtDisplay);// �߾�����

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);// ��60,����30
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));// ��������:top-right-bottom-left��

		btnConn = new Button("start");// ���۹�ư ����
		btnConn.setPrefSize(60, 30);// ��ư ����60,����30
		btnConn.setOnAction(e -> {// ��ư�� �̺�Ʈ �߰�
			if (btnConn.getText().equals("start")) {// ��ư�� ���ڿ��� start�̸�..
				startClient();// ȣ��
			} else if (btnConn.getText().equals("stop")) {// ��ư�� ���ڿ��� stop�̸�..
				stopClient();// ȣ��
			}
		});

		btnSend = new Button("send");// �޼��� ���� ��ư ����
		btnSend.setPrefSize(60, 30);// ����60,����30
		btnSend.setDisable(true);// �ʱⰪ���� �̺�Ʈ�Ұ��� ó��
		btnSend.setOnAction(e -> send(txtInput.getText()));// ���ڿ��Է�â��ü�� txtInput�� ���ڿ���
		// �޾Ƽ� send()�޼ҵ忡 ���� ->�޼��� ����

		bottom.setCenter(txtInput);// �߾�����
		bottom.setLeft(btnConn);// ���� ��ư ���������� ����
		bottom.setRight(btnSend);// �޼��� ���� ��ư�� ���������� ����

		root.setBottom(bottom);// �ǳڿ� �Ʒ������� ��ġ

		Scene scene = new Scene(root);// �ǳ��� Scene()�� �������� �Ű������� ����
		scene.getStylesheets().add(getClass().getResource("app.css").toString());// ��Ÿ�� ����
		primaryStage.setScene(scene);// Scene��ü�� Stage�� ����
		primaryStage.setTitle("Client");// ������â�� Ÿ��Ʋ�� Client�� ����
		primaryStage.setOnCloseRequest(event -> stopClient());
		// ������ ���� ��� X��ư�� ������ ����ǰ� ����
		primaryStage.show();// �����츦 ȭ�鿡 ���̰� ����
		// ȭ�鱸�� ��

	}

	void stopClient() {// Client ���� �޼ҵ�
		try {
			Platform.runLater(() -> {
				displayText("[���� ����]"); // UI�ܿ� �޼��� ���
				btnConn.setText("start");// �����ư�� "stop" -> "start" ����
				btnSend.setDisable(true);// �޼��� ���� ��ư�� ���۵����·� ����
			});// �Ű��������� ���ϰ��� ���� ���ٽ�
			if (socket != null && !socket.isClosed()) {
				// ���� ��ü������ null���� ������ ������ ����������
				socket.close();// ������ ����
			}
		} catch (IOException ie) {
		}
	}

	void send(String data) {// send()�޼ҵ��� �Ű������� data�� ����
		Thread thread = new Thread() {// �޼��� ���� �۾� ���� ����
			@Override
			public void run() {
				try {
					byte[] byteArr = data.getBytes("UTF-8");// charSet�� utf-8�� ����-�ѱ� ����
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(byteArr);// OutputStream���� data�̵�
					outputStream.flush();// ����Ÿ �о�� �� ���� ����
					Platform.runLater(() -> displayText("[������ �Ϸ�]"));
				} catch (Exception e) {
					Platform.runLater(() -> displayText("[���� ��� �Ϸ�]"));// ȭ�鿡 ���
					stopClient();// Ŭ���Ʈ ���� �޼ҵ� ȣ��
				}
			}
		};// �޼��� ���� �۾� ���� ��
		thread.start();// run()�޼ҵ� ȣ�� �Ƿ�
	}

	void startClient() {// Ŭ���̾�Ʈ ���� �޼ҵ�
		Thread thread = new Thread() {// �۾��� thread ���� ����..
			@Override
			public void run() {
				try {
					socket = new Socket();// Ŭ���̾�Ʈ ���� ����
					socket.connect(new InetSocketAddress("192.168.0.93", 5001));// ������ ����
					Platform.runLater(() -> {// ���ٽ�
						displayText("[���� �Ϸ�:" + socket.getRemoteSocketAddress() + "]");// ���Ӹ޼��� ���
						btnConn.setText("stop");// ��ư�� �� ���ڿ� start->stop���� ����
						btnSend.setDisable(false);// �޼����� ������ �ְ� ����
					});
				} catch (Exception e) {// ���� �߻��� ó��
					Platform.runLater(() -> displayText("[������� �ȵ�]"));// �����޼��� ���
					if (!socket.isClosed()) {
						stopClient();
					} // ������ �������� ������ ���� �ݱ�
					return;// return������ ȣ���������� �̵�(�۾� ����)
				}
				receive();// �޼��� ���� �޼ҵ� ȣ��
			}
		};// thread�۾� ���� ����
		thread.start();// thread�� run()�޼ҵ� ȣ���Ƿ�
	}// startClient() ��

	void receive() {// �޼��� ���� �޼ҵ�
		while (true) {
			try {
				byte[] byteArr = new byte[100];// ���� 100¥�� byteŸ���� �迭 ����
				InputStream inputStream = socket.getInputStream();// �������κ��� InputStream����
				int readByteCount = inputStream.read(byteArr);// read(�迭)�� �о����
				// �迭�� �޼��� ���� �� ����� �޼����� ���̸� ����
				if (readByteCount == -1) {// inputStream���� ������ �޼����� ������ -1
					throw new IOException();// ���� �߻��Ͽ� ����->catch()������ ��� �̵�
				}
				// ���� �޼����� ���ڿ��� ���� �ϴµ� characterSet�� utf-8�� �����Ͽ� ����
				String data = new String(byteArr, 0, readByteCount, "UTF-8");
				Platform.runLater(() -> displayText("[�ޱ� �Ϸ�]" + data)); // ���Ź���
				// �޼����� ȭ�鿡 �Ѹ������� runLater()�޼ҵ� ȣ��
			} catch (Exception e) {// ���� ó��
				Platform.runLater(() -> displayText("[���� ��� �ȵ�]"));
				// �Ű����� ���� ���ٽ� () -> method()
				stopClient();// Ŭ���̾�Ʈ ���� �޼ҵ� ȣ��
				break;// �۾� ����
			}
		}

	}

	void displayText(String string) {// �Ű������� ���� ���ڿ� string������ ���� ��� �߰���
		txtDisplay.appendText(string + "\n");// ���پ� ��� �� ����

	}

}
