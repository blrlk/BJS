package ch04;
import java.util.*;

public class ex22_while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer = "Y";
		int count = 0;
		
		while(answer.equals("Y")) {
			System.out.println("음악 재생? (Y/N)");
			answer = sc.nextLine();
			
			if(answer.equals("Y")) {
				System.out.printf("음악을 %d번 재생했습니다.\n", ++count);
			}
		}
		System.out.printf("재생 종료\n최종 %d번 재생", count);

	}

}
