package ch09;

public class ex63_finally {

	public static void main(String[] args) {
		try {
			int[] a = { 2, 0 };
			int b = 4;
			int c = b / a[1];
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("산술 오류 발생");
		} finally {
			System.out.println("무조건 연결 해제");
		}
	}

}
