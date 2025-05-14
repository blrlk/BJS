package ch10;

public class format {

	public static void main(String[] args) {
		System.out.println(String.format("%d", 1234+5678));	//정수형
		System.out.println(String.format("%s", "1234" +"5678"));	//문자열
	}

}