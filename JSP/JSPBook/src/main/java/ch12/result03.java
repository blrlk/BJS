package ch12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filterResult03")
public class result03 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("filter03_process 연결 완료");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("passwd");
		
		req.setAttribute("id", id);
		req.setAttribute("pwd", pwd);
		System.out.println(id + pwd);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch12/filter03_process.jsp");
		ds.forward(req, resp);
	}
	

}
