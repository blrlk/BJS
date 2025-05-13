package ch10;

//문자 추출
public class charAt {

	public static void main(String[] args) {
		String a = "Hello Java!";
		char b = a.charAt(0);
		for(int i=0;i<a.length();i++) {
			System.out.println(a.charAt(i));
		}
	}

}
