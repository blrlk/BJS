//buy
package project1;

import java.util.Scanner;

public class buy {

	public void choice() {
		repository repository = new repository();
		String name = null;
		int option=0;
		int price = 0;
		String color = null;

		Scanner sc = new Scanner(System.in);
		Scanner scch = new Scanner(System.in);

		while (true) {
			System.out.println("자동차 선택");
			System.out.println("1. 소나타");
			System.out.println("2. 벤츠");

			int choiceCar = sc.nextInt();
			if (choiceCar == 1) {
				name = "소나타";
				price = 3000;
			} else if (choiceCar == 2) {
				name = "벤츠";
				price = 5000;
			} else {
				continue;
			}

			System.out.println("옵션 선택");
			System.out.println("1. 기본 옵션");
			System.out.println("2. 풀 옵션");

			int choiceOption = sc.nextInt();
			if (choiceOption == 1) {
				price += 1000;
			} else if (choiceOption == 2) {
				price += 2000;
			} else {
				continue;
			}

			System.out.println("색상 선택");
			System.out.println("1. 검정색");
			System.out.println("2. 흰색");
			
			int choiceColor = sc.nextInt();
			if (choiceColor == 1) {
				color = "black";
			} else if (choiceColor == 2) {
				color = "white";
			} else {
				continue;
			}
			
			
			System.out.println("구매자 이름");
			String user = scch.nextLine();
			System.out.println("구매자 번호(- 제외)");
			String phone = scch.nextLine();
			
			car makecar = new car(name, price, color, user, phone);
			
			//
			repository.repo.add(makecar);
			
			break;
		}
	}

}
