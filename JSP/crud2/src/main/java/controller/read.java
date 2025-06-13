package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.memberRepository;
import dto.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class read extends HttpServlet{
	memberRepository repo = memberRepository.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("read : doget");
		
		//preprocessing
		
		//model
		ArrayList<member> arr = repo.read();
		
		//view
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("view.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
