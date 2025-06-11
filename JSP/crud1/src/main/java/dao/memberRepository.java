package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.member;

public class memberRepository {
	private static memberRepository repo = new memberRepository();
	private memberRepository() {}
	public static memberRepository getInstance() {
		return repo;
	}
	
	//변수 선언
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//db 연결
	public Connection dbconn() throws ClassNotFoundException, SQLException {
		System.out.println("database에 연결합니다...");
		
		String url="jdbc:mysql://localhost:3306/member";
		String id="root";
		String pw="1234";
		
		//WEB-INF > lib 내 라이브러리 확보 확인 - mysql-connector-j-8.0.33.jar(Driver)
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}
	
	//create
	public void create(member mb) {
		System.out.println("== create 함수 입장 ==");
		
		try {
			conn = dbconn();
			System.out.println("db 연결 완료 - create");
			
			String sql = "insert into member values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPwd());
			pstmt.executeUpdate();
			System.out.println("데이터 추가 완료");
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	//read
	public ArrayList<member> read(){
		System.out.println("== read 함수 입장 ==");
		ArrayList<member> arr = new ArrayList<member>();
		
		try {
			conn = dbconn();
			System.out.println("db 연결 완료 - read");
			
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				member mb = new member();
				mb.setId(rs.getString("id"));
				mb.setPwd(rs.getString("pwd"));
				arr.add(mb);
			};
			
		} catch (Exception e) { e.printStackTrace(); }
		
		return arr;
		
	}
	
	public member readOne(String id) {
		System.out.println("== readOne 함수 입장 ==");
		member mb = new member();
		
		try {
			conn = dbconn();
			System.out.println("db 연결 완료 - readOne");
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setPwd(rs.getString("pwd"));
			}
			
		} catch (Exception e) { e.printStackTrace(); }
		
		return mb;
	}
	
	//update
	public void update(String id, String pwd) {
		System.out.println("== update 함수 입장 ==");
		
		try {
			conn=dbconn();
			System.out.println("db 연결 완료 - update");
			
			String sql = "update member set pwd=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			System.out.println("수정 완료");
		} catch (Exception e) { e.printStackTrace(); }
		
	}
	
	//delete
	public void delete(String id) {
		System.out.println("== delete 함수 입장 ==");
		
		try {
			conn = dbconn();
			System.out.println("db 연결 완료 - delete");
			
			String sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			System.out.println("삭제 완료");
		} catch (Exception e) { e.printStackTrace(); }
	}
}
