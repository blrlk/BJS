package ch09;

public class ex64_exception2 {

	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의 예외");
			throw e;
		} catch(Exception e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
		}
	}

}
