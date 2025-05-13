package ch10;

//앞뒤 공백 제거
public class trim {

	public static void main(String[] args) {
		String a = ("         Hello Java          ");
		System.out.println(a);
		String b = a.trim();
		System.out.println(b);
	}

}
