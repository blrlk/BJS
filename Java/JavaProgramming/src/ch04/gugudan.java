package ch04;

public class gugudan {

	public static void main(String[] args) {
		for(int i=2;i<=9;i++) {
			System.out.printf("== %d단 ==\n", i);
			for(int j=1;j<=9;j++) {
				System.out.printf("%d X %d = %2d\n", i, j, i*j);
			}
		}
		
		System.out.println();
		
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.printf("%d X %d = %2d\t", j, i, i*j);
			}
			System.out.println();
		}
		
	}

}
