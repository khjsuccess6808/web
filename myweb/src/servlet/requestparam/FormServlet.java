package servlet.requestparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		
		
		
		request.setCharacterEncoding("UTF-8");//만약 doGet방식일떄는 안해도 된다. 맨처음 Tomcat설치할때 url로 넘어오는것은 Utf-8로 하겠다고 설정해놓았기때문에
		
		String name=request.getParameter("name"); 
		String password=request.getParameter("password"); 
		String address=request.getParameter("address"); 
		String gender=request.getParameter("gender"); 
		String acceptMail=request.getParameter("acceptMail"); 
		String [] language=request.getParameterValues("language");
		String tel1=request.getParameter("tel1"); 
		String category=request.getParameter("category"); 
		String intro=request.getParameter("intro"); 

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head><title> 각종 입력 폼</title></head>");
		out.printf("이름:%s<br>%n",name);
		out.printf("패스워드:%s<br>%n",password);
		out.printf("주소:%s<br>%n",address);
		out.printf("성별:%s<br>%n",gender);
		out.printf("광고메일수신여부:%s<br>%n",acceptMail==null?"수신안함":"수신함");
		
		out.print("관심있는언어:");
	    for(int i=0;i<language.length;i++){
	    	
	    	if(i+1!=language.length){
	    		out.print(language[i]+",");
	    	}else{
	    		out.print(language[i]);
	    	}
	    }
		out.printf("<br>");
		out.printf("핸드폰 번호 앞자리:%s<br>%n",tel1);
		out.printf("상품분류:%s<br>%n",category);
		out.printf("설명:%s<br>%n",intro);
		out.println("</body></html>");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
