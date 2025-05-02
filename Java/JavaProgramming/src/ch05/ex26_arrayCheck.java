package ch05;
import java.util.*;

public class ex26_arrayCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 크기 지정 ");
		int num = sc.nextInt();
		sc.nextLine();	//숫자 입력 -> 문자 입력 시에 줄바꿈(\n)이 남을 수 있으므로 버퍼 초기화 필수
		System.out.println();
		
		int[] arr = new int[num];
		
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
		
		String[] arrString = new String[num];
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
