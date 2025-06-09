package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class connDB {
	public Connection dbconn() {
		System.out.println("db에 데이터 저장");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/testt";
		String user = "root";
		String pwd = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("db 연결 완료");
		} catch(Exception e) {System.out.println("db 연결 실패");}
		
		return conn;
	}
}
