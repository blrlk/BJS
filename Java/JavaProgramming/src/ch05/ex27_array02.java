package ch05;
import java.util.*;


public class ex27_array02 {
	public static void main(String[] args) {
		int[] a = new int[] { 10, 20, 4, 25, 18 };
		int[] b= {1,2,3, 4, 5, 6, 7};
		
		int[] c= new int[10];
		for(int i=0;i<10;i++) {
			c[i] = i;
		}
		
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]);
		}
		
		System.out.println();
		System.out.println(Arrays.toString(c));
	}
}
