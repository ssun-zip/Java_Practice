package Practice_1007;

import java.awt.*;


class MyFramee extends Frame {
	public MyFramee() {
		setLayout(new FlowLayout()); //객체생성 및 초기화
		Label lab1 = new Label("아이디 입력");
		TextField tf1 = new TextField("열공중" , 20);
		
		//생성, 초기화 및 텍스트가 나올 상자의 사이즈 지정
		
		Label lab2 = new Label("비번 입력"); // 생성, 초기화, 텍스트 지정
		TextField tf2 = new TextField(10);
		tf2.setEchoChar('*'); //비밀번호 입력을 *모양으로 표기하도록 설정
		add(lab1);
		add(tf1);//아이디 입력창을 패널에 추가
		add(lab2);
		add(tf2); //텍스트 창을 프레임에 추가
		
		setSize(200, 200);//패널의 가로 세로 크기를 설정
		setVisible(true);	 //나타내기
	}

	public static void main(String[] args) {
		new MyFramee();
		
	}

}

/*
	TextField tf1 = new TextField("아이디 입력",20); //생성,초기화 및 텍스트가 나올상자의 사이즈 지정
	TextField tf2 = new TextField("비밀번호 입력",10); //생성,초기화 및 텍스트가 나올상자의 사이즈 지정
	
	tf1.selectAll();   //아이디의 입력된 모든 문자열 선택가능
	tf2.selectAll();   //비밀번호의 입력된 모든 문자열 선택가능 
*/