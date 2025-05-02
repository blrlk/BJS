package ch05;
import java.util.*;

public class lotto {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		
		
		//lotto에 바로 집어넣고 중복되면 다시 그 인덱스 실행해서 덮어쓰기
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = random.nextInt(10)+1;
			System.out.println(lotto[i]);
			
			for(int j=0;j<i;j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		//num 변수에 랜덤 값 넣어서 기존 값들과 비교 후 중복 안 되면 lotto 변수에 넣기
		//중복 되면 index 값 -1;
//		for(int i=0;i<lotto.length;i++) {
//			int num = random.nextInt(10)+1;
////			System.out.println(num);
//			
//			// 중복검사
//			boolean state = false;
//			for(int j=0;j<i;j++) {
//				if(lotto[j] == num) {
//					state = true;
//					break;
//				}
//			}
//			
//			if(state) {
//				i--;
//			} else {
//				lotto[i] = num;
//			}
//			
//		}
		
		for(int i=0;i<lotto.length;i++) {
			System.out.printf("%d ", lotto[i]);
		}
		
		Arrays.sort(lotto);
		System.out.println("\n"+Arrays.toString(lotto));
	}

}
