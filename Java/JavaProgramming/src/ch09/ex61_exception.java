package ch09;

public class ex61_exception {

	public static void main(String[] args) {
		try {
			int[] a = { 2, 0 };
			int b = 4;
			int c = b / a[1];
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("산술 오류 발생");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 길이 오류 발생");
		}
		System.out.println("예외 처리 공부 중");
	}

}
