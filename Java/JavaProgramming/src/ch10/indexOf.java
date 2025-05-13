package ch10;

//문자 찾기 - 해당 위치 인덱스 반환
public class indexOf {

	public static void main(String[] args) {
		String a = "abcdefghijk";
		int b = a.indexOf("c");
		
		System.out.println("문자 c는 "+b+"번 째");
	}

}
