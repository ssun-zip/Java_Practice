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
		launch(args);// Application 실행
	}

	TextArea txtDisplay;// 메세지 출력객체
	TextField txtInput;// 메세지 입력객체
	Button btnConn, btnSend;// 버튼
	//화면 구성 시작

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);// 폭500,높이300

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);// 메세지 출력창 수정금지
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));// 마진설정
		root.setCenter(txtDisplay);// 중앙정렬

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);// 폭60,높이30
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));// 마진설정:top-right-bottom-left순

		btnConn = new Button("start");// 시작버튼 생성
		btnConn.setPrefSize(60, 30);// 버튼 가로60,세로30
		btnConn.setOnAction(e -> {// 버튼에 이벤트 추가
			if (btnConn.getText().equals("start")) {// 버튼의 문자열이 start이면..
				startClient();// 호출
			} else if (btnConn.getText().equals("stop")) {// 버튼의 문자열이 stop이면..
				stopClient();// 호출
			}
		});

		btnSend = new Button("send");// 메세지 전송 버튼 생성
		btnSend.setPrefSize(60, 30);// 가로60,높이30
		btnSend.setDisable(true);// 초기값으로 이벤트불가로 처리
		btnSend.setOnAction(e -> send(txtInput.getText()));// 문자열입력창객체인 txtInput의 문자열을
		// 받아서 send()메소드에 대입 ->메세지 전송

		bottom.setCenter(txtInput);// 중앙정렬
		bottom.setLeft(btnConn);// 접속 버튼 을왼쪽으로 정렬
		bottom.setRight(btnSend);// 메세지 전송 버튼을 오른쪽으로 정렬

		root.setBottom(bottom);// 판넬에 아래쪽으로 배치

		Scene scene = new Scene(root);// 판넬을 Scene()에 생성자의 매개변수로 대입
		scene.getStylesheets().add(getClass().getResource("app.css").toString());// 스타일 지정
		primaryStage.setScene(scene);// Scene객체를 Stage에 부착
		primaryStage.setTitle("Client");// 윈도우창의 타이틀을 Client로 지정
		primaryStage.setOnCloseRequest(event -> stopClient());
		// 윈도우 우측 상단 X버튼을 누르면 종료되게 설정
		primaryStage.show();// 윈도우를 화면에 보이게 설정
		// 화면구성 끝

	}

	void stopClient() {// Client 종료 메소드
		try {
			Platform.runLater(() -> {
				displayText("[연결 끊음]"); // UI단에 메세지 출력
				btnConn.setText("start");// 연결버튼을 "stop" -> "start" 변경
				btnSend.setDisable(true);// 메세지 전송 버튼을 미작동상태로 변경
			});// 매개변수없고 리턴값이 없는 람다식
			if (socket != null && !socket.isClosed()) {
				// 소켓 객체변수가 null값을 가지고 소켓이 열려있으면
				socket.close();// 소켓을 닫음
			}
		} catch (IOException ie) {
		}
	}

	void send(String data) {// send()메소드의 매개변수로 data가 들어옴
		Thread thread = new Thread() {// 메세지 전송 작업 정의 시작
			@Override
			public void run() {
				try {
					byte[] byteArr = data.getBytes("UTF-8");// charSet을 utf-8로 세팅-한글 전송
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(byteArr);// OutputStream으로 data이동
					outputStream.flush();// 데이타 밀어내기 및 버퍼 비우기
					Platform.runLater(() -> displayText("[보내기 완료]"));
				} catch (Exception e) {
					Platform.runLater(() -> displayText("[서버 통신 완료]"));// 화면에 출력
					stopClient();// 클라언트 종료 메소드 호출
				}
			}
		};// 메세지 전송 작업 정의 끝
		thread.start();// run()메소드 호출 의뢰
	}

	void startClient() {// 클라이언트 시작 메소드
		Thread thread = new Thread() {// 작업할 thread 정의 시작..
			@Override
			public void run() {
				try {
					socket = new Socket();// 클라이언트 소켓 생성
					socket.connect(new InetSocketAddress("192.168.0.93", 5001));// 서버쪽 접속
					Platform.runLater(() -> {// 람다식
						displayText("[연결 완료:" + socket.getRemoteSocketAddress() + "]");// 접속메세지 출력
						btnConn.setText("stop");// 버튼의 라벨 문자열 start->stop으로 변경
						btnSend.setDisable(false);// 메세지를 보낼수 있게 변경
					});
				} catch (Exception e) {// 예외 발생시 처리
					Platform.runLater(() -> displayText("[서버통신 안됨]"));// 오류메세지 출력
					if (!socket.isClosed()) {
						stopClient();
					} // 소켓이 닫혀있지 않으면 소켓 닫기
					return;// return문으로 호출한쪽으로 이동(작업 종료)
				}
				receive();// 메세지 수신 메소드 호출
			}
		};// thread작업 정의 종료
		thread.start();// thread의 run()메소드 호출의뢰
	}// startClient() 끝

	void receive() {// 메세지 수신 메소드
		while (true) {
			try {
				byte[] byteArr = new byte[100];// 길이 100짜리 byte타입의 배열 생성
				InputStream inputStream = socket.getInputStream();// 소켓으로부터 InputStream생성
				int readByteCount = inputStream.read(byteArr);// read(배열)로 읽어들임
				// 배열에 메세지 저장 후 저장된 메세지의 길이를 리턴
				if (readByteCount == -1) {// inputStream으로 들어오는 메세지가 없으면 -1
					throw new IOException();// 예외 발생하여 종료->catch()쪽으로 제어가 이동
				}
				// 받은 메세지를 문자열로 생성 하는데 characterSet을 utf-8로 변경하여 생성
				String data = new String(byteArr, 0, readByteCount, "UTF-8");
				Platform.runLater(() -> displayText("[받기 완료]" + data)); // 수신받은
				// 메세지를 화면에 뿌리기위해 runLater()메소드 호출
			} catch (Exception e) {// 예외 처리
				Platform.runLater(() -> displayText("[서버 통신 안됨]"));
				// 매개변수 없는 람다식 () -> method()
				stopClient();// 클라이언트 종료 메소드 호출
				break;// 작업 종료
			}
		}

	}

	void displayText(String string) {// 매개변수로 받은 문자열 string변수의 값을 계속 추가함
		txtDisplay.appendText(string + "\n");// 한줄씩 출력 후 개행

	}

}
