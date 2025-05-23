package ch05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request01")
public class ex01_request01 extends HttpServlet{

	//http://localhost:8080/JSPBook/request01?id=a&pw=1
	//?id=a&pw=1
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request 연결 완료");
		
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//모델이동 ::생략
		//뷰이동
		req.setAttribute("userID", id);
		req.setAttribute("userPW", pw);
		RequestDispatcher ds=req.getRequestDispatcher("ch05/01_request01_process.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}


}
