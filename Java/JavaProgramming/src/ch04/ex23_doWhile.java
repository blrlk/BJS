package ch04;
import java.util.*;

public class ex23_doWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer = "null";
		int count = 0;
		
		do {
			System.out.println("음악 재생? (Y/N)");
			answer = sc.nextLine();
			
			if(answer.equals("Y")) {
				System.out.printf("음악을 %d번 재생했습니다.\n", ++count);
			}
		} while(answer.equals("Y"));
		
		System.out.printf("재생 종료\n최종 %d번 재생", count);
	}

}
