package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.member;

public class memberRepository {
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;

	//DB 연결 함수
	public Connection dbconn() throws Exception {
		String url="jdbc:mysql://localhost:3306/membertest";
		String id="root";
		String pw="1234";
		
		//WEB-INF > lib 내 라이브러리 확보 확인 - mysql-connector-j-8.0.33.jar(Driver)
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}
	
	//create
	public void create(member mb) {
		System.out.println("repository: create 함수");
		System.out.println(mb.toString());
		
		String sql = "insert into member values(?, ?, ?)";
		try {
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPwd());
			pstmt.setString(3, mb.getName());
			pstmt.executeUpdate();	//executeUpdate : db에 데이터 넣기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update
	public void update(String id, String pwd, String name) {
		try {
			conn = dbconn();
			String sql = "update member set pwd=?, name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	//delete
	public void delete(String id) {
		try {
			conn=dbconn();
			String sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	//read
	public ArrayList<member> readAll() {
		ArrayList<member> memberSet = null; new ArrayList<member>();
		
		try {
			//DB 연결
			conn = dbconn();
			
			//쿼리 전송
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	//executeQuery : db의 데이터 가져오기			

			memberSet = new ArrayList<member>();
			
			while(rs.next()) {	//한 줄 ~ 여러 줄
				member mb = new member();	//하나의 행을 담기 위함
				mb.setId(rs.getString("id"));
				mb.setPwd(rs.getString("pwd"));
				mb.setName(rs.getString("name"));
				
				//여러 개의 객체 담을 ArrayList
				memberSet.add(mb);
			}			
			
		} catch (Exception e) { e.printStackTrace(); }
		
		//결과 반환
		return memberSet;
	}
	
	public member readOne(String id) {
		member mb = null;
		
		try {
			conn = dbconn();
			String sql = "select * from member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //한 줄
				mb = new member();
				mb.setId(rs.getString("id"));
				mb.setPwd(rs.getString("pwd"));
				mb.setName(rs.getString("name"));
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		return mb;
		
	}
}
