package servlet.requestparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadQueryStringServlet extends HttpServlet {

	//HTTP GET방식 요청을 처리하는 service 메소드.
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//1.요청파라미터 조회 + 검증
		//String name=request.getParameter("name");
		//같은 이름으로 여러개의 요청파라미터가 전달된 경우
		String [] names=request.getParameterValues("name");
		//요청파라미터는 문자열(String)으로 조회한다.
		String ageStr=request.getParameter("age");    
		                                     //Integer.parseInt(),Long.parseLong(),Double.parseDouble()
		
		//int age=Integer.parseInt(ageStr);  //숫자로 무조건 받아야 할떄면 이렇게 적어야함.
		//2.처리- 비지니스 로직
		//초기 파라미터 조회
		String filePath=getServletConfig().getInitParameter("filePath"); //null
		
		String phoneNumber=getServletContext().getInitParameter("phone number");
		String adminEmail=getServletContext().getInitParameter("admin email");
		
		//3.처리결과 응답
		
		response.setContentType("text/html;charset=UTF-8");//응답 content-type설정 및 한글처리
		PrintWriter out=response.getWriter();//응답 출력 스트림 조회
		out.println("<!doctype html>");
		out.println("<html><head><title>입력한 요청파라미터</title></head>");
		out.println("<body>");
		//out.printf("전달된 요청 파라미터-name=%s,age=%s%n",name,ageStr);
		out.printf("나이:%s<br>%n", ageStr);
		out.print("이름:");
	    for(int i=0;i<names.length;i++){
	    	out.print(names[i]+",");
	    	
	    } //바로 servlet실행하면 names는 현재 넘어온 내용이 없다.그래서 null이 뜬다. html에서 실행하면 null이 없다.
	    
	/*	for(int i=0;i<names.length;i++){
			out.printf("나이-%s%n,이름:%s%n",ageStr,names[i]);
		}*/
	    out.printf("<hr>filePath:%s <br>전화번호:%s<br> 관리자이메일:%s", filePath,phoneNumber,adminEmail);
	    out.println("</body></html>");
		
		//4.
		
	}
	
	
	
}
