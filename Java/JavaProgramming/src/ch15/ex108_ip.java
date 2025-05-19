package ch15;

import java.net.*;

public class ex108_ip {

	public static void main(String[] args) {
		InetAddress ip = null;
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName(): "+ip.getHostName());	//호스트 이름
			System.out.println("getHostAddress(): "+ip.getHostAddress());	//호스트 주소
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
