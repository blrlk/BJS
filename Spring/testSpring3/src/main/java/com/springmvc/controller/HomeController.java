package com.springmvc.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springmvc.domain.BookDTO;

@Controller
public class HomeController {
	Gson g = new Gson();	//java <-> json 문자열 변환 돕는 객체
	
	@RequestMapping("/")
	public String main() {
		return "home";
	}
	
	@GetMapping(value="/objtojson", produces="application/json;charset=UTF-8")	//한글
	@ResponseBody
	public String objtojson() {
		String json = null;
		BookDTO dto = new BookDTO("자바", 21000, "에이콘", 670);
		json = g.toJson(dto);	//dto를 json 형식으로 변환
		return json;
	}
	
	@GetMapping("/jsontoobj")
	public String jsontoobj() {
		String json ="{'title': '자바','price': 21000,'company': '에이콘','page': 670}";
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println(dto1);
		//BookDTO[title=자바, price21000, company=에이콘, page=670]
		return "home";	
	}
	
	@GetMapping(value="/listtojson", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String listtojson() {
		List<BookDTO> lst = new ArrayList<BookDTO>();
		lst.add(new BookDTO("자바1", 21000, "에이콘1", 570));
		lst.add(new BookDTO("자바2", 31000, "에이콘2", 670));
		lst.add(new BookDTO("자바3", 11000, "에이콘3", 370));
		
		String lstJson = g.toJson(lst);
		System.out.println(lstJson);
		
		return lstJson;
	}
	
	@GetMapping("/jsontolist")
	public String jsontolist() {
		String list ="[{'title':'자바1','price':21000,'company':'에이콘1','page':570},{'title':'자바2','price':31000,'company':'에이콘2','page':670},{'title':'자바3','price':11000,'company':'에이콘3','page':370}]";
		List<BookDTO> lst = g.fromJson(list, new TypeToken<List<BookDTO>>() {}.getType());
		
		for(BookDTO vo: lst) {
			System.out.println(vo);
		}
		
		return "home";
	}
	
	@GetMapping("/geo")
	public String geo(@RequestParam String address, HttpServletRequest request, Model model) {
		
		//before. parameter 확보
		System.out.println(address);
		
		String imagename=null;
		
		//API 요청을 위한 step 별 코드
		//step1 - step2 : url 생성
		try {
			//step 1: 전송할 텍스트 인코딩(한글 깨짐 방지)
			String addr = URLEncoder.encode(address, "UTF-8");
			
			//step 2: 네이버로 전송할 URL 작성 
			String client_id = "4ibvf7a7s4";
            String client_secret = "pcfd4vM5IVLhIpr1dgfWZyqVDIQZoCD6o3tCkQwx";
            
            String reqUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
            URL url = new URL(reqUrl);	//URL 생성
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
            
            //step 3: 네이버에게 요청 실시
            InputStreamReader getData = new InputStreamReader(con.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(getData);	//토큰(데이터)의 단위를 라인으로 변경
            
            //step 4: 문자열 데이터로 변환
            //String == StringBuffer :: 두 개 유사함
            String line;
            StringBuffer response = new StringBuffer();	//JSON //한 줄씩 읽어서 응답 클래스 안에 한 줄씩 입력
            while( (line = br.readLine()) != null ) {
            	System.out.println("running while : " + line);
            	response.append(line);
            }
            
            //step 5: 자바의 문자열을 JSON 기호를 인식하여 필요한 데이터를 추출하기
            JSONTokener tokener = new JSONTokener(response.toString());	//문자열을 인식하여 JSON배열, JSON객체를 인식할 수 있도록 도움
            JSONObject json = new JSONObject(tokener);	//JSON 객체로 생성
            System.out.println(json.toString());
            
            //이후 원하는 데이터를 가져올 수 있음. 아래와 같이 3가지 메서드 사용 가능
            	//1) getJSONObject("키")
            	//2) getJSONArray("키")
            	//3) get("키");	:: get은 반드시 원 데이터(저장하는 데이터: JSONObject, JSONArray, String)로 캐스팅
            
            
            JSONArray arr = json.getJSONArray("addresses");
            JSONObject obj = (JSONObject)arr.getJSONObject(0);
            System.out.println("obj: "+ obj);
            
            String x = (String)obj.get("x");
            String y = (String)obj.get("y");
            String eng = (String)obj.get("englishAddress");
            
            JSONArray postArr = obj.getJSONArray("addressElements");
            JSONObject postObj = (JSONObject) postArr.getJSONObject(8);
            //JSONObject postObj = (JSONObject) obj.getJSONArray("addressElements").getJSONObject(8);
            System.out.println("postobj: " + obj);

            String postcode = (String)postObj.get("shortName");

            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("eng: " + eng);
            System.out.println("postcode: " + postcode);
            
            imagename = image2(x, y, addr, request);
            
            
		} catch(Exception e) {}
		
		model.addAttribute("img", imagename);
		return "images";
	}
	
	
	
	public void image(String x, String y, String address) {
		System.out.println(x + y + address);
		
		try {
			//step 1: 전송할 텍스트 인코딩(한글 깨짐 방지)
			String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
	        String pos=URLEncoder.encode(x + " " + y, "UTF-8");
	        String url = URL_STATICMAP;
	        url += "center=" + x + "," + y;
	        url += "&level=16&w=700&h=500";
	        url += "&markers=type:t|size:mid|pos:"+pos+"|label:"+address;
			
	        //step 2: 네이버로 전송할 URL 작성
			URL u = new URL(url);
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "4ibvf7a7s4");
            con.setRequestProperty("X-NCP-APIGW-API-KEY","pcfd4vM5IVLhIpr1dgfWZyqVDIQZoCD6o3tCkQwx");
            
	        //step 3: 네이버에게 요청 실시
			InputStream is = con.getInputStream();
			
	        //step 4: 문자열 데이터로 변환
			String tempname = Long.valueOf(new Date().getTime()).toString(); 	//파일의 이름 생성 :: 시간 -> 중복 x 
			File f = new File(tempname + ".jpg");	//빈 파일 생성
			f.createNewFile();	//실제 파일 생성 명령어
			
			int read=0;
			byte[] bytes = new byte[1024];
			OutputStream outputStream = new FileOutputStream(f);
			while( (read=is.read(bytes)) != -1 ) {
				outputStream.write(bytes, 0, read);
			}
			
			is.close();
			outputStream.close();
			
			
		} catch(Exception e){System.out.println("error");}
	}
	
	public String image2(String x, String y, String address, HttpServletRequest request) 
	{
		  System.out.println(x);
	      System.out.println(y);
	      System.out.println(address);
	      
	      String tempname = null;
	      
	      try 
	      {
	         //Step 1 : 전송할 텍스트에 한글이 있으므로 깨지지않게 인코딩을 실시: 모든 전송에 필수적으로 필요함
	         String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
	         String pos=URLEncoder.encode(x + " " + y, "UTF-8");
	         String url = URL_STATICMAP;
	         url += "center=" + x + "," + y;
	         url += "&level=16&w=700&h=500";
	         url += "&markers=type:t|size:mid|pos:"+pos+"|label:"+address;
	         
	         //Step 2 : 네이버로 전송할 URL을 작성한다.
	         URL u = new URL(url);
	         HttpURLConnection con = (HttpURLConnection)u.openConnection();
	         con.setRequestMethod("GET");
	         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID","4ibvf7a7s4");
	         con.setRequestProperty("X-NCP-APIGW-API-KEY","pcfd4vM5IVLhIpr1dgfWZyqVDIQZoCD6o3tCkQwx");
	         
	         //Step 3 : 네이버에게 요청을 실시한다.
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         InputStream is=null;
	         if(responseCode==200) { // 정상 호출
	             is = con.getInputStream();
	         }
	         else {
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) { response.append(inputLine);
	            } br.close();
	            System.out.println(response.toString());
	         }
	         //이미지저장

	         
	         //Step 4 : 문자열 데이터로 변환
	         tempname = Long.valueOf(new Date().getTime()).toString(); //파일의 이름생성
	         String path = request.getRealPath("resources/images");	//() 안에 webapp 이후 경로
	         tempname = tempname + ".jpg";
	         System.out.println(path);
	         File f = new File(path+"/"+tempname); // 빈파일을 생성
	         f.createNewFile(); //실제 파일생성 명령어
	         
	         int read = 0;
	         byte[] bytes = new byte[1024];
	         OutputStream outputStream = new FileOutputStream(f);
	         while ((read =is.read(bytes)) != -1) { 
	            outputStream.write(bytes, 0, read);
	         } 
	         is.close();
	         outputStream.close();
	         
	         System.out.println(f.getAbsolutePath().toString());
	         
	      }catch(Exception e) {}
	      
	      return tempname;

	}
	
}
