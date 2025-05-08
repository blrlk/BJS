package ch06;

public class ex38_overloading {

	static int sum(int a, int b) {
		System.out.println("인자 둘");
		return a+b;
	}
	
	static int sum(int a, int b, int c) {
		System.out.println("인자 셋");
		return a+b+c;
	}
	
	static double sum(double a, double b, double c) {
		System.out.println("double type");
		return a+b+c;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(3, 2));
		System.out.println(sum(3, 4, 5));
		System.out.println(sum(3.2, 2.3, 1.2));
	}

}
