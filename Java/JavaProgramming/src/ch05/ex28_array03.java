package ch05;

public class ex28_array03 {

	public static void main(String[] args) {
		int[] student = {100, 95, 90, 88, 93};
		
		int sum=0;
		
		for(int i=0;i<student.length;i++) {
			sum += student[i];
		}
		
		
		System.out.printf("시험 점수 평균: %.2f", sum / (float)student.length);
	}

}
