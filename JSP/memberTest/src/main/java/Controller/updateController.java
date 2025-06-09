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

@WebServlet("/update")
public class updateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update : doget");
		
		//전처리
		String id = req.getParameter("id");
		
		//모델이동
		memberRepository repo = new memberRepository();
		member mb = repo.readOne(id);
		
		//뷰이동
		req.setAttribute("member", mb);
		RequestDispatcher ds = req.getRequestDispatcher("updateForm.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update : dopost");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		memberRepository repo = new memberRepository();
		repo.update(id, pwd, name);
		
		resp.sendRedirect("readall");

	}

}
