// 2020.09.28
// 생성자 오버로딩(여러개 선언): 수와 타입이 다르다면 여러개의 생성자 선언 가능
// 연습예제

public class Date {
	private int year;
	private String month;
	private int day;
	
	public Date() {
		this(1900, "1월", 1);
	}
	
	public Date(int year) {
		this(year, "1월", 1);

	}
	
	public Date(int year, String month, int day) {
		this.month = month;
		this.year = year;
		this.day = day;
	}
	
	@Override	
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public static void main(String[] args) {
		Date obj1 = new Date(2015, "8월", 10);
		Date obj2 = new Date(2020);
		Date obj3 = new Date();

		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());

	}

}

/*	Output:
*	Date [year=2015, month=8월, day=10]
	Date [year=2020, month=1월, day=1]
	Date [year=1900, month=1월, day=1]

*/