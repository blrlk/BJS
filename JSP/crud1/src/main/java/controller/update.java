package controller;

import java.io.IOException;

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
		
		//전처리
		String id = req.getParameter("id");
		
		//모델 이동
		member mb = repo.readOne(id);
		
		//뷰이동
		req.setAttribute("mb", mb);
		RequestDispatcher ds = req.getRequestDispatcher("update.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update : dopost");
		
		//전처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//모델이동
		repo.update(id, pwd);

		//뷰이동
		resp.sendRedirect("read");
	}
	
}
