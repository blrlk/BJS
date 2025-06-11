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

@WebServlet("/create")
public class create extends HttpServlet{
	memberRepository repo = memberRepository.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("create : doget");
		RequestDispatcher ds = req.getRequestDispatcher("form.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("create : dopost");
		
		//전처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		member mb = new member(id, pwd);
		System.out.println("create:dopost - " + mb.toString());
		
		//모델 이동
		repo.create(mb);
		
		//뷰이동
		resp.sendRedirect("read");
	}

}
