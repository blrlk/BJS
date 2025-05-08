//고객 관리 프로그램
//start
package project1;

import java.util.*;

public class start {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("== 자동차 구매 프로그램 ==");
			System.out.println("원하는 서비스 선택");
			System.out.println("1. 구매");
			System.out.println("2. 회원 조회");
			System.out.println("3. 전체 구매 이력 조회");
			System.out.println("0. EXIT");

			int choice = sc.nextInt();

			if(choice == 0) {
				System.out.println("Exit");
				break;
			}
			
			buy by = new buy();
			search srch = new search();
			
			switch (choice) {
			case 1:
				System.out.println("구매 선택");
				by.choice();
				break;
			case 2:
				System.out.println("회원 조회 선택");
				break;
			case 3:
				System.out.println("전체 구매 이력 조회 선택");
				srch.allsearch();
				break;
			default:
				continue;
			}
		}
	}

}
