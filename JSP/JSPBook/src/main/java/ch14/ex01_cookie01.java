package ch14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie01")
public class ex01_cookie01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("cookie01 연결 완료");
		RequestDispatcher ds = req.getRequestDispatcher("ch14/01_cookie01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("id");
		String userPW = req.getParameter("passwd");
		
		if(userID.equals("admin") && userPW.equals("1234")) {
			Cookie cookie_id = new Cookie("userID", userID);
			Cookie cookie_pw = new Cookie("userPW", userPW);
			resp.addCookie(cookie_id);
			resp.addCookie(cookie_pw);
			System.out.println("쿠키 생성 성공");
		} else {
			System.out.println("쿠키 생성 실패");
		}
		
		req.setAttribute("userid", userID);
		req.setAttribute("userpw", userPW);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch14/cookie01_process.jsp");
		ds.forward(req, resp);
		
	}

}
