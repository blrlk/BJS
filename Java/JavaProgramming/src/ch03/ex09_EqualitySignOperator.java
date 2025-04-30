package ch03;

public class ex09_EqualitySignOperator {

	public static void main(String[] args) {
		double a= 3.14;
		double b=5.14;
		System.out.println(a==b);
		System.out.println(a!=b);
		
		String c1 = "Hello JAVA!";
		System.out.println(c1);
		System.out.println(c1.equals("Hello java!"));
		System.out.println(c1.equals("Hello JAVA!"));
	}

}
