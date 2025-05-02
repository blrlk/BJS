package ch05;

public class ex26_array01 {

	public static void main(String[] args) {
		int[] student = new int[3];
		System.out.println("자동 초기화 : " + student[0]);
		
		student[0] = 30;
		student[1] = 20;
		student[2] = 40;
		
		System.out.println("현재 첫 번째 요소 값 : "+student[0]);
	}

}
