package ch05;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request02")
public class ex02_request02<E> extends HttpServlet{

	//http://localhost:8080/JSPBook/request01?id=a&pw=1
	//?id=a&pw=1
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request2 연결 완료");
		
		HashMap<String, String> data = new HashMap<String, String>();
		Enumeration<E> en = (Enumeration<E>) req.getHeaderNames();
		while(en.hasMoreElements()) {
			String headerName = (String) en.nextElement();
			String headerValue = req.getHeader(headerName);
			
			data.put(headerName, headerValue);
		}
		
		req.setAttribute("mapData", data);
		
		RequestDispatcher ds=req.getRequestDispatcher("ch05/02_request02.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}


}
