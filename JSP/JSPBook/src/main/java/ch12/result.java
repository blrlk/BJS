package ch12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filterResult01")
public class result extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("filter01_process 연결 완료");
		
		String name = req.getParameter("name");
		req.setAttribute("name", name);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch12/filter01_process.jsp");
		ds.forward(req, resp);
	}

}
