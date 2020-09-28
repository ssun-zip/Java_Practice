// 2020.09.28
// Array와 생성자 병합. 
// 연습예제 CircleArray 

public class CircleArray {

	public static void main(String[] args) {
		Circle [] c = new Circle[5];
		
		for(int i = 0; i < c.length; i++) {
			c[i] = new Circle(i);
		} 
		// index:  0, 1, 2, 3, 4 ] > length = 5
		//    c  [ 0, 1, 2, 3, 4 ]
		
		for(int i = 0; i < c.length; i++) {
			//getArea = 3.14*radius*radius
			System.out.print((int)(c[i].getArea()) + " ");
		}
		// index:  0, 1, 2, 3, 4 ] > length = 5
		// result: 0, 3.14 , 12.56, 28.26, 50.24 
		//    c  [ 0, 3, 12, 28, 50 ] > (int format: 정수)
		

	}

}

		// output: 0 3 12 28 50