package sec1.ex05;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*") //WebFilter annotation이용해 모든요청이 필터를 거치게됩니다. 

//사용자 정의 필터는 반드시 Filter 인터페이스 구현 
public class EncoderFilter implements Filter{ 
	ServletContext context;
	
	public void init(FilterConfig fCongif) throws ServletException {
		System.out.println("utf-8 encoding ....");
		context = fCongif.getServletContext();
	}
	
	// doFilter() 안에서 실제 필터 기능 구현 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter 호출 ");
		request.setCharacterEncoding("utf-8"); // 한국어 인코딩 적옵 
		// 웹 애플리케이션의 컨텍스트 이름 가져옵니다. 
		String context = ((HttpServletRequest) request). getContextPath();
		// 웹 브라우저에서 요청한 요청 URI 가져온다 
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		// 요청 URI의 실제 경로 가져온다. 
		String realPath = request.getRealPath(pathinfo);
		String mesg = "Context 정보 :" + context + "\n URI 정보: " + pathinfo + "\n 물리적 경로: " + realPath;
		System.out.println(mesg);
		
		long begin = System.currentTimeMillis();
		// 요청 필터에서 요청 처리 전의 시각을 구합니다. 
		// 다음 필터로 넘기는 작업 수행 
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		// 응답 필터에서 요청처리 후의 시각을 구합니다. 
		System.out.println("작업시간: " +(end - begin) + "ms" );
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy called ");
	
	}

}
