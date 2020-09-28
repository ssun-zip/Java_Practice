// 2020.0928
// 생성자를  class 
// Sep_28 main() 메소드의 생성자

public class Box {
	int width;
	int length;
	int height;
	int volume;
	
	public int getVolume(){
		return volume;
	}

	Box(int w, int l, int h){
		width = w;
		length = l;
		height = h;
		volume = width*height*length;
	}
	
}
