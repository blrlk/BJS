package ch10;

//문자열 값 비교 - 동일하면 true, 다르면 false
public class equals {

	public static void main(String[] args) {
		String a = "Java";
		String b = "Java?";
		System.out.println(a.contentEquals(b));
	}

}
