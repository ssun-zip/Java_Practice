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
	ExecutorService executorService;// 스레드풀
	ServerSocket serverSocket;// 접속할 서버소켓
	List<Client> connections = new Vector<>();// 클라이언트 저장객체
												// thread-safe방식구현
	TextArea textDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();//
		root.setPrefSize(500, 500);// 사이즈 500,500

		textDisplay = new TextArea();// 문자입력창 객체 생성
		textDisplay.setEditable(false);// 문자 수정 불가
		BorderPane.setMargin(textDisplay, new Insets(0, 0, 2, 0));// 판넬의 마진조정
		root.setCenter(textDisplay);// 중앙 정렬

		btnStartStop = new Button("start");// 버튼 객체 생성 라벨을 "start"로
		btnStartStop.setPrefHeight(30);// 30pixel
		btnStartStop.setMaxWidth(Double.MAX_VALUE);// 최대폭 지정
		btnStartStop.setOnAction(e -> {// 람다식=이벤트 처리 메소드 부착(setOnAction)
			if (btnStartStop.getText().equals("start")) {
				startServer();
			} else if (btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);// 버튼을 판넬의 아래쪽에 붙임

		Scene scene = new Scene(root);// root판넬을 Scene의 생성자의 매개변수로 대입
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		//화면을 꾸며줄 css파일을 찾아서 Stylsheet에 저장		 
		primaryStage.setScene(scene);// Scene객체를 Stage에 부착
		primaryStage.setTitle("Server");// Stage의 타이틀 부여
		primaryStage.setOnCloseRequest(event -> stopServer());
		// 람다식 stopServer()메소드 호출
		primaryStage.show();// 객체를 화며에 보이게 함

	}

	private void stopServer() {// 채팅 서버 종료 메소드
		try {
			Iterator<Client> iterator = connections.iterator();// vector에 저장된 객체들 추출
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();// 클라이언트 소켓 닫기
				iterator.remove();// iterator데이타 를 제거 -remove()
			}
			// 서버소켓 객체가 없고, 서버소켓이 닫혀있지 않으면 서버소켓 닫기
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// 스레드풀 객체가 없고, 스레드풀이 종료되지 않았다면 스레드풀 종료
			if (executorService != null && !executorService.isShutdown()) {
				executorService.shutdown();
			}
			Platform.runLater(() -> { // UI 화면의 글자와 버튼의 글자 변경
				displayText("[서버멈춤]");
				btnStartStop.setText("start");// stop->start로 변경
			});
		} catch (Exception e) {
		}
	}

	private void startServer() {// 채팅 서버기동 메소드
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());// 스레드 풀 생성-사용 가능한
																									// cpu 갯수 만큼 생성
		try {
			serverSocket = new ServerSocket();// 서버소켓 객체 생성
			serverSocket.bind(new InetSocketAddress("192.168.0.93", 5001));
			// 서버 주소와 포트 번호부여
		} catch (Exception e) {
			if (!serverSocket.isClosed()) {
				stopServer();
			} // 서버소켓 닫기
			return;// 작업종료
		}
		Runnable runnable = new Runnable() {// 쓰레드 객체 생성
			@Override
			public void run() {
				Platform.runLater(() -> {
					displayText("[서버시작]");
					btnStartStop.setText("stop");// 버튼의 라벨 글자를 start->stop으로 변경
				});
				while (true) {
					try {
						Socket socket = serverSocket.accept();// 접속 기다리기
						String message = "[연결수락:" + socket.getRemoteSocketAddress() + ":"
								+ Thread.currentThread().getName() + "]";
						Platform.runLater(() -> displayText(message));
						Client client = new Client(socket);// client객체 생성
						connections.add(client);// vector객체에 Client객체 저장
						Platform.runLater(() -> displayText("[연결 갯수:" + connections.size() + "]"));
					} catch (Exception e) {
						if (!serverSocket.isClosed()) {
							stopServer();
						} // 서버소켓 닫기
						break;// 작업종료
					}
				} // while()문 끝
			}
		};// 작업 정의 종료
		executorService.submit(runnable);// 서버 스레드풀에 작업 요청
	}

	void displayText(String text) {
		textDisplay.appendText(text + "\n");// 메세지를 입력받아서textDisplay객체에
											// 저장 후 개행하는 메소드
	}

	public static void main(String[] args) {
		launch(args);
	}

//Client클래스 시작
	class Client {
		Socket socket;// 소켓 필드

		public Client(Socket socket) {// 매개변수 1개짜리 생성자
			this.socket = socket;
			receive();// 수신메소드
		}

		void receive() {
			Runnable runnable = new Runnable() {// 리턴값이 필요없는 작업
				@Override
				public void run() {// run()메소드 재정의
					try {
						while (true) {
							byte[] byteArr = new byte[100];// byte배열 생성-길이100
							InputStream inputStream = socket.getInputStream();// 소켓으로 부터 inputStream생성
							int readByteCount = inputStream.read(byteArr);// 배열에 바이트 단위값 저장 후 길이 리턴
							if (readByteCount == -1) {
								throw new IOException();
							}
							String message = "[요청퍼리:" + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));// 메세지를 뿌려주고
							String data = new String(byteArr, 0, readByteCount, "UTF-8");// 문자열 utf-8로 세팅
							for (Client client : connections)// 접속되어있는 모든 클라이언트들에게
								client.send(data);// 메세지를 보맴
						}
					} catch (Exception e) {
						try {
							connections.remove(Client.this);// vector에서 자신을 제거
							String message = "[클라이언트 통신 안됨:" + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]"; // 메세지
							Platform.runLater(() -> displayText(message));// UI화면에 문자 출력
							socket.close();// 소켓닫기
						} catch (IOException ie) {
						}
					}
				}
			};
			executorService.submit(runnable);// 스레드풀에 작업 요청
		}

		void send(String data) {// data를 매개변수로 받음
			Runnable runnable = new Runnable() {// 리턴값을 받지 않는 작업 정의 -Runnable
				@Override
				public void run() {
					try {
						byte[] byteArr = data.getBytes("UTF-8");// utf-8로 세팅
						OutputStream outputStream = socket.getOutputStream();// 스트림객체 생성
						outputStream.write(byteArr);// 스트림을 통해 메세지 전송
						outputStream.flush();// 데이타 밀어내기 및 버퍼 비우기
					} catch (Exception e) {// 예외 발생시
						try {// 에러 메세지 생성
							String message = "[클라이언트 통신 안됨:" + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));// 화면에 메세지 출력
							connections.remove(Client.this);// vector에서 자신을 삭제
							socket.close();// 소켓 닫기
						} catch (IOException ie) {
						}
					}
				}
			};
			executorService.submit(runnable);// 서버 스레드 풀에 작업 요청
		}
	}// Client클래스 끝

}
