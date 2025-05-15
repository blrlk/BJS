package ch10;

import java.util.Random;

public class ex74_random1 {

	public static void main(String[] args) {
		Random random = new Random();
		Random random2 = new Random();
		Random random3 = new Random();
		
		for(int i=0;i<5;i++) {
			System.out.println("기본 생성자: "+random.nextInt());
		}
		System.out.println();
		
		for(int i=0;i<5;i++) {
			System.out.println("random2: "+(i+1)+"번째 값"+ (random2.nextInt(11)+20));	//20-30
		}
		System.out.println();
		
		for(int i=0;i<5;i++) {
			System.out.println("random3: "+(i+1)+"번째 값"+ (random3.nextInt(60)+100));	//100-159
		}
	}

}
