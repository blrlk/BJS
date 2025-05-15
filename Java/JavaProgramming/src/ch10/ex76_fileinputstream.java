package ch10;

import java.io.FileInputStream;
import java.util.Scanner;

public class ex76_fileinputstream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("sample.txt");
			Scanner s = new Scanner(fis);
			while(s.hasNext()) {
				System.out.println(s.nextLine());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
