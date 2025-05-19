package ch13;

import java.io.*;

public class ex100_file1 {

	public static void main(String[] args) throws IOException {
		//데이터 수신
		FileInputStream fis = null;
		fis = new FileInputStream("prac.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		//데이터 출력
		FileOutputStream fos = null;
		fos = new FileOutputStream("result.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int data;
	
		while((data = bis.read())!= -1) {
			bos.write(data);
		}
		bos.close();
		bis.close();
		
	}

}
