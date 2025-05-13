package ch10;

//인수 기준으로 문자열 나누기
public class split {

	public static void main(String[] args) {
		String a = "kor,eng,math";
		String div[] = a.split(",");
		
		for(int i=0;i<div.length;i++) {
			System.out.println(div[i]);
		}
	}

}
