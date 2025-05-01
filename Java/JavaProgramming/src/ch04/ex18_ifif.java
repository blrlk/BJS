package ch04;

import java.util.Scanner;

public class ex18_ifif {

	public static void main(String[] args) {
		String id, pwd;
		Scanner input = new Scanner(System.in);
		System.out.println("아이디 입력: ");
		id = input.nextLine();
		
		if(id.equals("java")) {
			System.out.println("아이디 일치");
			System.out.println("비밀번호 입력");
			pwd = input.nextLine();
			if(pwd.equals("abc123")) {
				System.out.println("비밀번호 일치");
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호 불일치");
			}
		} else {
			System.out.println("아이디 불일치");
		}
		
	}

}
