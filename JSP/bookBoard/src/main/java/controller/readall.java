package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BoardRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class readall extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum = Integer.parseInt(req.getParameter("pageNum")); //pageNum == null 인 경우 오류 발생
		
		//String pageno = req.getParameter("pageNum");
		//if(pageno != null) {	//pageNum이 null이 아닌 경우에만 실행
		//	int pageNum2 = Integer.parseInt(pageno);
		//}
		
		BoardRepository repository = BoardRepository.getInstance();
		ArrayList arr = repository.readall(pageNum);
		int total_record = repository.getListCount();
		
		
		req.setAttribute("arr", arr);
		req.setAttribute("total_record", total_record);
		req.setAttribute("pageNum", pageNum);
		RequestDispatcher ds = req.getRequestDispatcher("boardview.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	

}
