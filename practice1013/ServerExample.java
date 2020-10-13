package practice1013;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
	ExecutorService executorService;// ������Ǯ
	ServerSocket serverSocket;// ������ ��������
	List<Client> connections = new Vector<>();// Ŭ���̾�Ʈ ���尴ü
												// thread-safe��ı���
	TextArea textDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();//
		root.setPrefSize(500, 500);// ������ 500,500

		textDisplay = new TextArea();// �����Է�â ��ü ����
		textDisplay.setEditable(false);// ���� ���� �Ұ�
		BorderPane.setMargin(textDisplay, new Insets(0, 0, 2, 0));// �ǳ��� ��������
		root.setCenter(textDisplay);// �߾� ����

		btnStartStop = new Button("start");// ��ư ��ü ���� ���� "start"��
		btnStartStop.setPrefHeight(30);// 30pixel
		btnStartStop.setMaxWidth(Double.MAX_VALUE);// �ִ��� ����
		btnStartStop.setOnAction(e -> {// ���ٽ�=�̺�Ʈ ó�� �޼ҵ� ����(setOnAction)
			if (btnStartStop.getText().equals("start")) {
				startServer();
			} else if (btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);// ��ư�� �ǳ��� �Ʒ��ʿ� ����

		Scene scene = new Scene(root);// root�ǳ��� Scene�� �������� �Ű������� ����
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		//ȭ���� �ٸ��� css������ ã�Ƽ� Stylsheet�� ����		 
		primaryStage.setScene(scene);// Scene��ü�� Stage�� ����
		primaryStage.setTitle("Server");// Stage�� Ÿ��Ʋ �ο�
		primaryStage.setOnCloseRequest(event -> stopServer());
		// ���ٽ� stopServer()�޼ҵ� ȣ��
		primaryStage.show();// ��ü�� ȭ�翡 ���̰� ��

	}

	private void stopServer() {// ä�� ���� ���� �޼ҵ�
		try {
			Iterator<Client> iterator = connections.iterator();// vector�� ����� ��ü�� ����
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();// Ŭ���̾�Ʈ ���� �ݱ�
				iterator.remove();// iterator����Ÿ �� ���� -remove()
			}
			// �������� ��ü�� ����, ���������� �������� ������ �������� �ݱ�
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// ������Ǯ ��ü�� ����, ������Ǯ�� ������� �ʾҴٸ� ������Ǯ ����
			if (executorService != null && !executorService.isShutdown()) {
				executorService.shutdown();
			}
			Platform.runLater(() -> { // UI ȭ���� ���ڿ� ��ư�� ���� ����
				displayText("[��������]");
				btnStartStop.setText("start");// stop->start�� ����
			});
		} catch (Exception e) {
		}
	}

	private void startServer() {// ä�� �����⵿ �޼ҵ�
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());// ������ Ǯ ����-��� ������
																									// cpu ���� ��ŭ ����
		try {
			serverSocket = new ServerSocket();// �������� ��ü ����
			serverSocket.bind(new InetSocketAddress("192.168.0.93", 5001));
			// ���� �ּҿ� ��Ʈ ��ȣ�ο�
		} catch (Exception e) {
			if (!serverSocket.isClosed()) {
				stopServer();
			} // �������� �ݱ�
			return;// �۾�����
		}
		Runnable runnable = new Runnable() {// ������ ��ü ����
			@Override
			public void run() {
				Platform.runLater(() -> {
					displayText("[��������]");
					btnStartStop.setText("stop");// ��ư�� �� ���ڸ� start->stop���� ����
				});
				while (true) {
					try {
						Socket socket = serverSocket.accept();// ���� ��ٸ���
						String message = "[�������:" + socket.getRemoteSocketAddress() + ":"
								+ Thread.currentThread().getName() + "]";
						Platform.runLater(() -> displayText(message));
						Client client = new Client(socket);// client��ü ����
						connections.add(client);// vector��ü�� Client��ü ����
						Platform.runLater(() -> displayText("[���� ����:" + connections.size() + "]"));
					} catch (Exception e) {
						if (!serverSocket.isClosed()) {
							stopServer();
						} // �������� �ݱ�
						break;// �۾�����
					}
				} // while()�� ��
			}
		};// �۾� ���� ����
		executorService.submit(runnable);// ���� ������Ǯ�� �۾� ��û
	}

	void displayText(String text) {
		textDisplay.appendText(text + "\n");// �޼����� �Է¹޾Ƽ�textDisplay��ü��
											// ���� �� �����ϴ� �޼ҵ�
	}

	public static void main(String[] args) {
		launch(args);
	}

//ClientŬ���� ����
	class Client {
		Socket socket;// ���� �ʵ�

		public Client(Socket socket) {// �Ű����� 1��¥�� ������
			this.socket = socket;
			receive();// ���Ÿ޼ҵ�
		}

		void receive() {
			Runnable runnable = new Runnable() {// ���ϰ��� �ʿ���� �۾�
				@Override
				public void run() {// run()�޼ҵ� ������
					try {
						while (true) {
							byte[] byteArr = new byte[100];// byte�迭 ����-����100
							InputStream inputStream = socket.getInputStream();// �������� ���� inputStream����
							int readByteCount = inputStream.read(byteArr);// �迭�� ����Ʈ ������ ���� �� ���� ����
							if (readByteCount == -1) {
								throw new IOException();
							}
							String message = "[��û�۸�:" + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));// �޼����� �ѷ��ְ�
							String data = new String(byteArr, 0, readByteCount, "UTF-8");// ���ڿ� utf-8�� ����
							for (Client client : connections)// ���ӵǾ��ִ� ��� Ŭ���̾�Ʈ�鿡��
								client.send(data);// �޼����� ����
						}
					} catch (Exception e) {
						try {
							connections.remove(Client.this);// vector���� �ڽ��� ����
							String message = "[Ŭ���̾�Ʈ ��� �ȵ�:" + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]"; // �޼���
							Platform.runLater(() -> displayText(message));// UIȭ�鿡 ���� ���
							socket.close();// ���ϴݱ�
						} catch (IOException ie) {
						}
					}
				}
			};
			executorService.submit(runnable);// ������Ǯ�� �۾� ��û
		}

		void send(String data) {// data�� �Ű������� ����
			Runnable runnable = new Runnable() {// ���ϰ��� ���� �ʴ� �۾� ���� -Runnable
				@Override
				public void run() {
					try {
						byte[] byteArr = data.getBytes("UTF-8");// utf-8�� ����
						OutputStream outputStream = socket.getOutputStream();// ��Ʈ����ü ����
						outputStream.write(byteArr);// ��Ʈ���� ���� �޼��� ����
						outputStream.flush();// ����Ÿ �о�� �� ���� ����
					} catch (Exception e) {// ���� �߻���
						try {// ���� �޼��� ����
							String message = "[Ŭ���̾�Ʈ ��� �ȵ�:" + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));// ȭ�鿡 �޼��� ���
							connections.remove(Client.this);// vector���� �ڽ��� ����
							socket.close();// ���� �ݱ�
						} catch (IOException ie) {
						}
					}
				}
			};
			executorService.submit(runnable);// ���� ������ Ǯ�� �۾� ��û
		}
	}// ClientŬ���� ��

}
