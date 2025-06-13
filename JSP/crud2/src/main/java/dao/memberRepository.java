package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.member;


public class memberRepository {
	private static memberRepository repo = new memberRepository();
	private memberRepository() {}
	public static memberRepository getInstance() {
		return repo;
	}
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//dbconn
	public Connection dbconn() throws Exception {
		System.out.println("database에 연결합니다...");
		
		String url="jdbc:mysql://localhost:3306/a";
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
			conn=dbconn();
			System.out.println("[create] db 연결 완료");
			
			String sql = "insert into aa value(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getName());
			pstmt.setInt(2, mb.getAge());
			pstmt.executeUpdate();
			System.out.println("데이터 추가 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//read - return 
	public ArrayList<member> read() {
		System.out.println("== read 함수 입장 ==");
		ArrayList<member> arr = new ArrayList<member>();
		
		try {
			conn=dbconn();
			System.out.println("[read] db 연결 완료");
			
			String sql = "select * from aa";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member mb = new member();
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				arr.add(mb);
			}
			
		} catch(Exception e) {
			e.printStackTrace();			
		}
		return arr;
	}
	
	public member readOne(String name) {
		System.out.println("== readone 함수 입장 ==");
		member mb = new member();
		
		try {
			conn = dbconn();
			System.out.println("[readond] db 연결 완료");
			
			String sql = "select * from aa where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mb;
	}
	
	//update
	public void update(String name, int age) {
		System.out.println("== update 함수 입장 ==");
		
		try {
			conn = dbconn();
			System.out.println("[update] db 연결 완료");
			
			String sql = "update aa set age=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			System.out.println("데이터 수정 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//delete
	public void delete(String name) {
		System.out.println("== delete 함수 입장 ==");
		
		try {
			conn = dbconn();
			System.out.println("[delete] db 연결 완료");
			
			String sql = "delete from aa where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			System.out.println("데이터 삭제 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
