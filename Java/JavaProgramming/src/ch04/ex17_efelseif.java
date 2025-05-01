package ch04;
import java.util.*;


public class ex17_efelseif {
	
	public static void main(String[] args) {
		int age;
		Scanner input = new Scanner(System.in);	//System.in: 콘솔
		
		// 콘솔에서 문자로 입력받기
//		String tmp = input.nextLine();
//		age = Integer.parseInt(tmp);
		
		// 콘솔에서 숫자로 입력받기
		age = input.nextInt();
		
		if(age>19) {
			System.out.println("성인");
			System.out.println("성인 요금 적용");
		} else if(age>13) {
			System.out.println("청소년");
			System.out.println("청소년 요금 적용");
		} else if(age>8) {
			System.out.println("어린이");
			System.out.println("어린이 요금 적용");
		} else {
			System.out.println("유아");
			System.out.println("유아 요금 적용");
		}
		System.out.println("결제 진행");
	}

}
