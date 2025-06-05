package dao;

import java.sql.*;
import java.util.ArrayList;

import controller.connDB;
import dto.person;

public class personRepository {
	private static personRepository repo = new personRepository();
	private personRepository() {}
	
	public static personRepository getInstance() {
		return repo;
	}
	connDB db = new connDB();
	
	public void save(person ps) {
		System.out.println(ps.toString());
		Connection conn = db.dbconn();
		
		PreparedStatement pstmt = null;
		String sql = "insert into person values(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ps.getName());
			pstmt.setInt(2, ps.getAge());
			pstmt.executeUpdate();
			System.out.println("데이터 저장 완료");
		} catch(Exception e) {System.out.println("데이터 저장 실패");}
	}
	
	public ArrayList<person> readAll(person ps) {
		ArrayList<person> all = new ArrayList<person>();
		
		Connection conn = db.dbconn();
		
		return all;
	}
}
