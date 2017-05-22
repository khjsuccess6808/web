package servlet.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*1.public class, HttpServlet 상속, no-arqument 생성
 *2.callback 메소드(lifecycle메소드) 재정의
 *                                   -실행환경(Web Cotainer)이 특정 시점에 호출하는 메소드
 *    +init():초기화
 *    +service() => doGet()||doPost(): 사용자 요청을 처리하는 메소드.
 *    +destroy(): 마무리(객체 소멸 전에 호출)
 *3. web.xml에 등록=> Web Container에게 구현한 Servlet(객체)를 등록.   
 */

public class CounterServlet extends HttpServlet {

	private int counter;
	
	
	public CounterServlet() {
		System.out.println("CounterServlet 생성자 실행.");
	}

	public void init() {
		ServletConfig config=getServletConfig();
		String filePath=config.getInitParameter("filePath");
		//String filePath=getServletConfig().getInitParameter("filePath")
		System.out.println("CounterServlet.init()실행- 파일("+filePath+")에서 counter변수값을 조회");
	}

	public void destroy() {
        String filePath=getServletConfig().getInitParameter("filePath");
		System.out.println("CounterServlet.destroy()실행-파일("+filePath+")에서 counter변수값을 조회");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("CounterSerlvet.service()-doGet() 실행");
       //count를 증가
	  counter++;
	  
	  //ServletContext를 이용해 초기 파라미터 조회
	  ServletContext context=getServletContext();
	  String phoneNumber=context.getInitParameter("phone number");
	  String adminEmail=context.getInitParameter("admin email");
	  
	  //MyListener의 contextInitialized()에서 등록한 "resource"속성 조회
	  String resource=(String)context.getAttribute("resource");// return 타입이 object인데 실제 타입으로 형변환 해줘야 한다.//그래야 제대로 읽을수 있다.
	  
	  
	  
	  
	  
	  
	  
	  //count의 값을 사용자에게 응답처리.
	  //1.응답 content-type 지정.MIME타입
	  response.setContentType("text/html;charset=UTF-8");  //html로 지정할건데 그 형식이 text야~
	  //2.(웹브라우저 사용자)에게 응답하기위한 출력 stream조회
	  PrintWriter out=response.getWriter();
	  //3.응답
	  out.println("<!doctype html>");
	  out.println("<html><head><title>카운터</title></head>");
	  out.printf("<body>당신은 %d번쨰 요청자입니다.<br>",counter);
	  out.println("<a href='/myweb/index.html'>index페이지</a>");
	  out.println("<hr>");
	  out.printf("전화번호: %s 관리자 이메일 주소: %s<br>",phoneNumber,adminEmail);
	  out.printf("Attribute:%s", resource);
	  out.println("</body></html>");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
