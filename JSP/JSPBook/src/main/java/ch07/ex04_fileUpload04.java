package ch07;

import java.io.IOException;
import java.util.HashMap;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileUpload04")
public class ex04_fileUpload04 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("fileUpload04 doGet 입장");
		RequestDispatcher ds = req.getRequestDispatcher("ch07/04_fileUpload04.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("fileUpload04 doPost 입장");
		
		String save = req.getServletContext().getRealPath("sources/images");
		int max = 1024*1024*5;
		String encoding = "utf-8";
		DefaultFileRenamePolicy rename=new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(req, save, max, encoding, rename);
		
		String name = multi.getParameter("Name");
		String subject = multi.getParameter("Subject");
		String file = multi.getFilesystemName("Filename");
		
		req.setAttribute("name", name);
		req.setAttribute("subject", subject);
		req.setAttribute("file", file);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch07/fileUpload04_process");
		ds.forward(req, resp);

	}
	

}
