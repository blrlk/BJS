package ch15;

import java.net.*;
import java.io.*;

public class ex111_clientClass {

	public static void main(String[] args) {
		try {
			String serverIp = "172.16.13.62";
			System.out.println("서버 연결 시도");
			
			Socket socket = new Socket(serverIp, 8000);
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			System.out.println("서버로부터 받은 메시지: "+dis.readUTF());
			dis.close();
			socket.close();
			System.out.println("연결 종료");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
