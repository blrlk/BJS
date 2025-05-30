package ch13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session01")
public class ex01_session01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("session01 연결 완료");
		RequestDispatcher ds = req.getRequestDispatcher("ch13/01_session01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if("admin".equals(id) && pwd.equals("1234")) {
			//로그인 성공 로직
			//1.세션 생성
			//true: 없으면 새로 만들고 있으면 그냥 그거 줘, default
			//false: 없으면 null, 있으면 그냥 그거 줘
			HttpSession session = req.getSession(true);	//일종의 싱글톤 방식, 로그인 할 때 한 번만 사용
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
		}
		
		RequestDispatcher ds = req.getRequestDispatcher("ch13/sessionSuccess.jsp");
		ds.forward(req, resp);
		
	}
	
}
