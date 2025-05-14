package ch10;

//객체의 기본형을 String으로 변환 -> 데이터를 문자형으로 변환 후 반환
public class valueOf {
	public static void main(String[] args) {
		int a = 1;
		int b=2;
		System.out.println(a+b);
		String c = String.valueOf(a);	//문자열 "1" 변환
		String d = String.valueOf(b);	//문자열 "2" 변환
		
		System.out.println(c+d);	//문자열 연결
	}
}
