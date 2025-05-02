package ch05;

public class sort {
	public static void main(String[] args) {
		int[] arr = {95, 43, 33, 45, 54, 1, 7};
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] < arr[j]) {
					continue;
				} else {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				
//				for(int k=0;k<arr.length;k++) {
//					System.out.printf("%d ", arr[k]);
//				}
//				System.out.println();
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d ", arr[i]);
		}
		
	}
}
