package ch03;

public class ex10_logicOperator2 {
	public static void main(String[] args) {
		int a=10;
		System.out.println(5<a && a<15);
		System.out.println((5<a && a<15) && a%2==0);
		
		a=4;
		System.out.println((5<a &&a<15) && a%2 ==0);
		System.out.println((5<1 && a<15)||a%2 ==0);
	}
}
