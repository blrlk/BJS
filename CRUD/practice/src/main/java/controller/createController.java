package controller;

import java.io.IOException;

import dao.personRepository;
import dto.person;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class createController extends HttpServlet{
	personRepository repo = personRepository.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("create 연결 완료");
		RequestDispatcher rs = req.getRequestDispatcher("create.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("form data 받음");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println(name + ", " + age);
		
		person ps = new person();
		ps.setName(name);
		ps.setAge(age);
		
		repo.save(ps);
		
		resp.sendRedirect("create");
	}

}
