// 2020.0928
// 생성자를 main class와 함께 프로그래밍 

public class Book {
	
	String title;
	String author;
	
	public Book(String t) { //생성자
		title = t;
		author ="작가미상";
	}
	
	public Book(String t, String a) { //생성자
		title = t;
		author = a;
	}
	
	public static void main(String[] args) {
		Book littlePrince = new Book("어린왕자" ,"생텍쥐페리");
		Book loveStory = new Book("춘향전");
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(loveStory.title + " " + loveStory.author);
	}

}

/*
	output:
	어린왕자 생텍쥐페리
	춘향전 작가미상

*/