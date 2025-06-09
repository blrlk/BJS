package Controller;

import java.io.IOException;
import java.util.ArrayList;

import DAO.memberRepository;
import DTO.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class readAll extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("readall : doget");
		
		//전처리 : 없음
		//모델이동
		memberRepository repo = new memberRepository();
		ArrayList<member> arr = repo.readAll();	//readAll의 return type: ArrayList
		
		//뷰이동 - 데이터 존재 -> 데이터 가지고 forward(sendRedirect 안 됨)
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("allView.jsp");
		ds.forward(req, resp);
	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("readall : dopost");

	}

}
