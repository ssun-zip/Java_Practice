public class Television {
	// 상태 속성 필드 
	// OOP 방식 - televisionTest()
	int channel;
	int volume;
	boolean onOff;
	
	void print() {
		System.out.println("채널은 " + channel + "이고 볼륨은 " + volume + "입니다");
	}
	
	int getChannel() {
		return channel;
	}
	
	void setChannel(int ch) {
		channel = ch;
	}
}
