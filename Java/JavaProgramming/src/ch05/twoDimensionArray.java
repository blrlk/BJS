package ch05;

public class twoDimensionArray {

	public static void main(String[] args) {
		int[][] test = new int[3][4];
		
		int cnt=0;
		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[i].length;j++) {
				test[i][j] = cnt;
				cnt++;
			}
		}
		
		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[i].length;j++) {
				System.out.printf("%d ", test[i][j]);
			}
			System.out.println();
		}
	}

}
