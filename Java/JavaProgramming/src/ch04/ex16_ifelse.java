package ch04;

public class ex16_ifelse {

	public static void main(String[] args) {
		int age=15;
		if(age>19) {
			System.out.println("성인");
			System.out.println("성인 요금 적용");
		} else {
			System.out.println("청소년");
			System.out.println("청소년 요금 적용");
		}
		System.out.println("결제 진행");
	}

}
