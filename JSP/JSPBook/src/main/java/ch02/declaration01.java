package ch02;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//애노테이션이라 하고 특정 객체 자동으로 생성 NoCodeBase
//localhost:8080/JSPBook2/exam2_1
@WebServlet("/declaration01")

public class declaration01 extends HttpServlet{

	//get 방식 입장
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("연결 완");
		RequestDispatcher ds = req.getRequestDispatcher("ch02/declaration01.jsp");
		ds.forward(req, resp);
	}

	//post 방식 입장
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
