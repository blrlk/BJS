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
		//전처리
		//모델이동
		ArrayList<member> arr = repo.read();
		
		//뷰이동
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("view.jsp");
		ds.forward(req, resp);
		System.out.println("view 완료");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
