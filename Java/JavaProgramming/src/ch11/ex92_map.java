package ch11;

import java.util.HashMap;
import java.util.Scanner;

public class ex92_map {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		
		hm.put("apple", "사과");
		hm.put("paper", "종이");
		hm.put("paper", "꽃");
		
		String voca;
		System.out.println("알고 싶은 단어 입력 ");
		voca = sc.nextLine();
		
		if(hm.containsKey(voca)) {
			System.out.println(hm.get(voca));
		} else {
			System.out.println("그런 단어 없다");
		}
		
	}

}
