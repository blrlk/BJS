package filter;

import java.io.IOException;
import java.util.Calendar;
import java.text.*;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("BookMarket 초기화");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("=== doFilter 시작 ===");
		System.out.println("접속한 클라이언트 IP: " + request.getRemoteAddr());
		long start = System.currentTimeMillis();
		System.out.println("접근한 URI 경로: " + getURLPath(request));
		System.out.println("요청 처리 시작 시간: " + getCurrentTime());
		filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

	}
	
	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath="";
		String queryString="";
		
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest)request;
			currentPath=req.getRequestURI();
			queryString=req.getQueryString();
			queryString= queryString == null ? "" : "?" + queryString;
		}
		return currentPath + queryString;
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

}
