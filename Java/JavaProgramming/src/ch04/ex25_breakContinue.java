package ch04;

import java.util.*;

public class ex25_breakContinue {

	public static void main(String[] args) {
		int money = 10000;
		System.out.printf("현재 가진 돈은 %d원 입니다.\n", money);

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("얼마를 사용하시겠습니까?");
			int i = sc.nextInt();

//			if(!(i>=0 && i<=money))
			if (i < 0 || i > money) {
				System.out.println("다시 입력");
				continue;
			}

			money -= i;
			System.out.printf("이제 %d원 남았습니다.\n", money);

			if (money == 0) {
				System.out.println("모든 돈 사용 완료");
				break;
			}

		}

	}

}
