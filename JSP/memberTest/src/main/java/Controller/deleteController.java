package Controller;

import java.io.IOException;

import DAO.memberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class deleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete : doget");
		
		//전처리
		String id = req.getParameter("id");
		
		//모델 이동
		memberRepository repo = new memberRepository();
		repo.delete(id);
		
		//뷰 이동
		resp.sendRedirect("readall");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete : dopost");
	}

}
