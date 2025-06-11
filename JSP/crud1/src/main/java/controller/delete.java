package controller;

import java.io.IOException;

import dao.memberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet{
	memberRepository repo = memberRepository.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete : doget");
		
		//전처리
		String id = req.getParameter("id");
		
		//모델이동
		repo.delete(id);
		
		//뷰이동
		resp.sendRedirect("read");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
