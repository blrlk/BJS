package Controller;

import java.io.IOException;

import DAO.memberRepository;
import DTO.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class createController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("create : doget");
		
		//전처리: 없음
		//모델이동: 넣을 데이터도 가져올 데이터도 없음
		//뷰이동
		RequestDispatcher ds = req.getRequestDispatcher("form.jsp");
        ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("create : dopost");
		
		//전처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		System.out.println(id + ", " + pwd + ", " + name);
		
		//전처리 : 묶음
		member mb = new member(id, pwd, name);
		System.out.println(mb.toString());

		//모델이동
		memberRepository repo = new memberRepository();
		repo.create(mb);
		
		//뷰이동
		resp.sendRedirect("readall");
	}
	
}
