package ch07;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileUpload01")
public class ex01_fileUpload01<E> extends HttpServlet{
	
	//폼 제공
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("fileUpload01 doGet 입장");
		
		RequestDispatcher ds = req.getRequestDispatcher("ch07/01_fileUpload01.jsp");
		ds.forward(req, resp);
	}

	//폼 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Step1. 여기까지 접근
		System.out.println("fileUpload01 doPost 입장");
		
		//Step2. 전처리
		//String id = req.getParameter("id");
		//MultipartRequest는 마라미터 5개 줘야 함 :: 리퀘스트, 저장폴더, 사이즈, 인코딩, 이름관련객체
		String save = req.getServletContext().getRealPath("resources/images");
		System.out.println(save);
		int max = 1024*1024*5;	//5MB
		String encoding="utf-8";
		DefaultFileRenamePolicy rename=new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(req, save, max, encoding, rename);
		
		//text 가져오기 case1
		String name = multi.getParameter("name");	//req. 하면 안 나옴
		String subject = multi.getParameter("subject");
		System.out.println(name);
		System.out.println(subject);
		
		//text 가져오기 case2
		Enumeration<E> keys = multi.getParameterNames();
		HashMap<String, String> hm = new HashMap<String, String>();
		while(keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = multi.getParameter(key);
			hm.put(key, value);
			System.out.println("키 값은 "+key +" value 값은 "+value);
		}
		
		//이미지 이름 가져오기
		String imageName1 = multi.getOriginalFileName("filename");	//저장 전 파일 이름
		String imageName2 = multi.getFilesystemName("filename");	//저장 후 파일 이름
		System.out.println(imageName1);
		System.out.println(imageName2);
		
		//Step3. 모델이동
		
		//Step4. 뷰이동
		req.setAttribute("name1", name);
		req.setAttribute("subject1", subject);
		req.setAttribute("image1", imageName2);
		RequestDispatcher ds = req.getRequestDispatcher("ch07/fileUpload01_process.jsp");
		ds.forward(req, resp);
		
	}
	
}
