package ch02;

public class charResearch {

	public static void main(String[] args) {
		// char에 대한 연구
		// 숫자도 문자도 되는 마법의 변수

		// Step 1. char에 데이터 넣기
		// 데이터 'A'는 문자와 숫자 두 가지 모두 가능
		char a = 'A'; // A 출력
		char b = 65; // A 출력 -> 자동형변환

		int c = 'A'; // 65 출력 -> 자동형변환

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//char 변수 <- int 변수
//		a = c;
		//int 변수 <- char 변수
		c = a;
		
		// char(2) ->(o) int(4) ->(x) char(2)
		System.out.println(c);
	}

}