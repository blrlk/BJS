package ch07;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileUpload02")
public class ex02_fileUpload02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("fileUpload02 doGet 입장");
		
		RequestDispatcher ds = req.getRequestDispatcher("ch07/02_fileUpload02.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("fileUpload02 doPost 입장");
		
		String save = req.getServletContext().getRealPath("resources/images");
		int max=1024*1024*5;	//5MB
		String encoding = "utf-8";
		DefaultFileRenamePolicy rename=new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(req, save, max, encoding, rename);
		
		String name1 = multi.getParameter("name1");
		String subject1 = multi.getParameter("subject1");
		String imageName1 = multi.getFilesystemName("filename1");
		
		String name2 = multi.getParameter("name2");
		String subject2 = multi.getParameter("subject2");
		String imageName2 = multi.getFilesystemName("filename2");
		
		String name3 = multi.getParameter("name3");
		String subject3 = multi.getParameter("subject3");
		String imageName3 = multi.getFilesystemName("filename3");
		System.out.println(imageName1 + ", " + imageName2 + ", " + imageName3);

		
		//전송
		req.setAttribute("name1", name1);
		req.setAttribute("subject1", subject1);
		req.setAttribute("image1", imageName1);
		
		req.setAttribute("name2", name2);
		req.setAttribute("subject2", subject2);
		req.setAttribute("image2", imageName2);
		
		req.setAttribute("name3", name3);
		req.setAttribute("subject3", subject3);
		req.setAttribute("image3", imageName3);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch07/fileUpload02_process.jsp");
		ds.forward(req, resp);
	}
	

}
