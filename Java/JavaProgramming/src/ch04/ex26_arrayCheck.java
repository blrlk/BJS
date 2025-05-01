package ch04;
import java.util.*;

public class ex26_arrayCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 크기 지정 ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		int[] arr = new int[num];
		String[] arrString = new String[num];
		
		//숫자
//		for(int i=0;i<num;i++) {
//			System.out.printf("%d번째 배열 값 ", i);
//			int value = sc.nextInt();
//			arr[i] = value;
//			System.out.println();
//		}
//		
//		
//		for(int i=0;i<num;i++) {
//			System.out.printf("%d ", arr[i]);
//		}
		
		// 문자열
		for(int i=0;i<num;i++) {
			System.out.printf("%d번째 배열 값 ", i);
			String value = sc.nextLine();
			arrString[i] = value;
			System.out.println();
		}
		
		for(int i=0;i<num;i++) {
			System.out.println(arrString[i]);
		}
	}

}
