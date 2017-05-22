package servlet.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 삭제
 *
 */
public class SetCookie3Servlet extends HttpServlet{
 
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//전송된 쿠키중 이름이 currentTime인 쿠키를 (Web Browser에서) 삭제
		
	   /* Cookie[] cookies=req.getCookies();
	    
	    for(int i=0;i<cookies.length;i++){
	    	if(cookies[i].getName().equals("currentTime")){
	    		cookies[i].setMaxAge(0);
	    		resp.addCookie(cookies[i]);
	    		break;
	    	}
	    }*/
		Cookie c=new Cookie("currentTime","1");  //value값은 상관없다. 그래서 아무값이나 넣음
		c.setMaxAge(120);
		resp.addCookie(c);
		
	
			
		
		//응답 : request.jsp로 이동
		req.getRequestDispatcher("/cookie/request.jsp").forward(req, resp);
		
		
		
	}
	
}
