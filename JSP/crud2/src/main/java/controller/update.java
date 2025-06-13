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

@WebServlet("/update")
public class update extends HttpServlet{
	memberRepository repo = memberRepository.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update : doget");
		
		//preprocessing
		String name = req.getParameter("name");
		
		//model
		member mb = repo.readOne(name);
		
		//view
		req.setAttribute("mb", mb);
		RequestDispatcher ds = req.getRequestDispatcher("update.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update : dopost");
		
		//pre
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		//model
		repo.update(name, age);
		
		//view
		resp.sendRedirect("read");
	}

}
